package com.boots.controller;

import com.boots.entity.ReadyFigures;
import com.boots.repository.ComposedFigureRepository;
import com.boots.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

@Controller
public class AdminController {
    @Autowired
    private UserService userService;
    @Autowired
    ComposedFigureRepository composedFigureRepository;

    ArrayList<ReadyFigures> readyFigures;

    @RequestMapping(value = "/constructionsite")
    String buildConstruct(Model model,
                          HttpServletRequest request,
                          HttpSession session){
        model.addAttribute("FigureOptions",composedFigureRepository.findAll());
        readyFigures = new ArrayList<>();

        //Добавление в модель 'ссылок на фигуры' четвертей 0Q 1Q 2Q 3Q
        for (int i = 1 ;i<=4;i++) {
            if (request.getParameter("same"+i) != null) {
                String[] splited = request.getParameter("same"+i).toString().split("\\s+");
                if(splited.length>1)
                    readyFigures.add( new ReadyFigures(splited[1],i,splited[0]));

            }
        }
        //Если добавлись/были выбраны фигуры
        if(readyFigures!=null && !readyFigures.isEmpty())
            model.addAttribute("ReadyFigures",readyFigures);

        return "constructionsite";
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
