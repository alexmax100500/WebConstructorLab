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
import org.springframework.web.bind.annotation.RequestBody;

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
        public String dots(@RequestBody String sx, @RequestBody String sy, @RequestBody String sr){
        int x = Integer.getInteger(sx);
        int y = Integer.getInteger(sy);
        int r = Integer.getInteger(sr);
        boolean t = checker.check(x,y,r);
        return "X: "+x+" Y: "+y+" R: "+r+ " T: "+ t;
    }

}
