package com.boots.controller;

import com.boots.entity.Graph.ComposedFigure;
import com.boots.entity.GraphStructure;
import com.boots.service.shapes.Checker;
import com.boots.service.shapes.GraphShapes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class UserController {
    @Autowired
    GraphStructure<ComposedFigure> submittedStructure;
    @Autowired
    Checker checker;

    @GetMapping("/userconstruct")
     public String userconstruct(Model model,
                                 HttpServletRequest request,
                                 HttpSession session){
        model.addAttribute("submittedStructure", submittedStructure);
        return "/userconstruct";
    }
    @PostMapping("/dots")
    @ResponseBody
        public String dots(@RequestParam double X, @RequestParam double Y, @RequestParam double R){
//        double x = Double.valueOf( request.getParameter("X"));
//        double y = Double.valueOf( request.getParameter("Y"));
//        double r = Double.valueOf( request.getParameter("R"));
        boolean t = checker.check(X,Y,R);
        return "<td>"+X+"</td>"+"<td>"+Y+"</td>"+"<td>"+R+"</td>"+"<td>"+t+"</td>";
    }

}
