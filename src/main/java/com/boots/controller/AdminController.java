package com.boots.controller;

import com.boots.entity.Graph.ComposedFigure;
import com.boots.entity.GraphStructure;
import com.boots.repository.ComposedFigureRepository;
import com.boots.service.UserService;
import com.boots.service.shapes.GraphShapes;
import com.boots.service.shapes.Shape;
import com.boots.service.shapes.ShapeBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class AdminController {
    @Autowired
    private UserService userService;
    @Autowired
    ComposedFigureRepository composedFigureRepository;
    @Autowired
    @Qualifier("GraphShapes")
    GraphShapes graphShapes;
    @Autowired
    ShapeBuilder shapeBuilder;
    //На вывод, после того, как были выбраны фигуры и типы инпутов админом
    @Autowired
    GraphStructure<ComposedFigure> submittedStructure;

    @RequestMapping(value = "/constructionsite")
    String buildConstruct(Model model,
                          HttpServletRequest request,
                          HttpSession session){
        model.addAttribute("FigureOptions",composedFigureRepository.findAll());
        //Добавление в модель 'ссылок на фигуры' четвертей 0Q 1Q 2Q 3Q
        submittedStructure.clear();
        for (int i = 1 ;i<=4;i++) {
            ComposedFigure figure;
            if (request.getParameter("same"+i) != null) {
                String[] splited = request.getParameter("same"+i).toString().split("\\s+");
                if(splited.length>1) {
                    figure = new ComposedFigure(splited[1], i, splited[0]);
                    buildShape(i, figure);
                    submittedStructure.add(figure);
                }
            }
            else {
                figure = new ComposedFigure("none", i, "resources/static/background/none.png");
                buildShape(i, figure);
                submittedStructure.add(figure);
            }
        }

        //Если добавлись/были выбраны фигуры
        if(submittedStructure!=null)
            model.addAttribute("ReadyFigures",submittedStructure);

        return "constructionsite";
    }

    private void buildShape(int i, ComposedFigure figure) {
        Shape shape = shapeBuilder.createShape(figure.getFigure(), figure.getRx(), figure.getRy());
        switch(i){
            case 0:
                graphShapes.setRightUpperShape(shape);
                break;
            case 1:
                graphShapes.setLeftUpperShape(shape);
                break;
            case 2:
                graphShapes.setLeftLowerShape(shape);
                break;
            case 3:
                graphShapes.setRightLowerShape(shape);
        }
    }

    @GetMapping("/admin")
    public String userList(Model model) {
        model.addAttribute("allUsers", userService.allUsers());
        return "admin";
    }

    @PostMapping("/admin")
    public String  deleteUser(@RequestParam(required = true, defaultValue = "" ) Long userId,
                              @RequestParam(required = true, defaultValue = "" ) String action,
                              Model model) {
        if (action.equals("delete")){
            userService.deleteUser(userId);
        }
        return "redirect:/admin";
    }

    @GetMapping("/admin/gt/{userId}")
    public String  gtUser(@PathVariable("userId") Long userId, Model model) {
        model.addAttribute("allUsers", userService.usergtList(userId));
        return "admin";
    }
}
