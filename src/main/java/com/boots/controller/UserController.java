package com.boots.controller;

import com.boots.entity.Graph.ComposedFigure;
import com.boots.entity.GraphStructure;
import com.boots.service.shapes.Checker;
import com.boots.service.shapes.GraphShapes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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
        public String dots(Model model,
                           HttpServletRequest request,
                           HttpSession session ){
        int x = Integer.getInteger(request.getParameter("X"));
        int y = Integer.getInteger(request.getParameter("Y"));
        int r = Integer.getInteger(request.getParameter("R"));
        boolean t = checker.check(x,y,r);
        return "X: "+x+" Y: "+y+" R: "+r+ " T: "+ t;
    }

}
