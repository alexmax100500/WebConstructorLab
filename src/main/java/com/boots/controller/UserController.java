package com.boots.controller;

import com.boots.entity.Graph.ComposedFigure;
import com.boots.entity.GraphStructure;
import com.boots.service.shapes.GraphShapes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class UserController {
    @Autowired
    GraphShapes graphShapes;
    @Autowired
    GraphStructure<ComposedFigure> submittedStructure;
    @GetMapping("/userconstruct")
     public String userconstruct(Model model,
                                 HttpServletRequest request,
                                 HttpSession session){
        model.addAttribute("submittedStructure", submittedStructure);
        return "/userconstruct";
    }

}
