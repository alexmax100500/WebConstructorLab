package com.boots.service.shapes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Checker {
    @Autowired
    GraphShapes shapes;

    public boolean check(double x, double y){
        if(x>0){
            if(y>0){
                return shapes.rightUpperShape.check(x,y);
            }
            if(y<0){
                return shapes.rightLowerShape.check(x,y);
            }
            if(y==0){
                return shapes.rightUpperShape.check(x,y) || shapes.rightLowerShape.check(x,y);
            }
        }
        if(x<0){
            if(y>0){
                return shapes.leftUpperShape.check(x,y);
            }
            if(y<0){
                return shapes.leftLowerShape.check(x,y);
            }
            if(y==0){
                return shapes.leftUpperShape.check(x,y) || shapes.leftLowerShape.check(x,y);
            }
        }
        if(x==0){
            if(y>0){
                return shapes.rightUpperShape.check(x,y) || shapes.leftUpperShape.check(x,y);
            }
            if(y<0){
                return shapes.leftLowerShape.check(x,y) || shapes.rightLowerShape.check(x,y);
            }
            if(y==0){
                return shapes.rightLowerShape.check(x,y) || shapes.rightUpperShape.check(x,y) || shapes.leftLowerShape.check(x,y) || shapes.leftUpperShape.check(x,y);
            }
        }
        return false;
    }

}
