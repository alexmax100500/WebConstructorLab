package com.boots.service.shapes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Checker {
    @Autowired
    GraphShapes shapes;

    public boolean check(double x, double y, double r){
        if(x>0){
            if(y>0){
                return shapes.rightUpperShape.check(x,y,r);
            }
            if(y<0){
                return shapes.rightLowerShape.check(x,y,r);
            }
            if(y==0){
                return shapes.rightUpperShape.check(x,y,r) || shapes.rightLowerShape.check(x,y,r);
            }
        }
        if(x<0){
            if(y>0){
                return shapes.leftUpperShape.check(x,y,r);
            }
            if(y<0){
                return shapes.leftLowerShape.check(x,y,r);
            }
            if(y==0){
                return shapes.leftUpperShape.check(x,y,r) || shapes.leftLowerShape.check(x,y,r);
            }
        }
        if(x==0){
            if(y>0){
                return shapes.rightUpperShape.check(x,y,r) || shapes.leftUpperShape.check(x,y,r);
            }
            if(y<0){
                return shapes.leftLowerShape.check(x,y,r) || shapes.rightLowerShape.check(x,y,r);
            }
            if(y==0){
                return shapes.rightLowerShape.check(x,y,r) || shapes.rightUpperShape.check(x,y,r) || shapes.leftLowerShape.check(x,y,r) || shapes.leftUpperShape.check(x,y,r);
            }
        }
        return false;
    }
}
