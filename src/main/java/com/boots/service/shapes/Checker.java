package com.boots.service.shapes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;

@Service
@ApplicationScope
public class Checker {
    @Autowired
    @Qualifier("GraphShapes")
    GraphShapes graphShapes;

    public boolean check(double x, double y, double r){
        if(x>0){
            if(y>0){
                return graphShapes.getRightUpperShape().check(x,y,r);
            }
            if(y<0){
                return graphShapes.getRightLowerShape().check(x,y,r);
            }
            if(y==0){
                return graphShapes.getRightUpperShape().check(x,y,r) || graphShapes.getRightLowerShape().check(x,y,r);
            }
        }
        if(x<0){
            if(y>0){
                return graphShapes.getLeftUpperShape().check(x,y,r);
            }
            if(y<0){
                return graphShapes.getLeftLowerShape().check(x,y,r);
            }
            if(y==0){
                return graphShapes.getLeftUpperShape().check(x,y,r) || graphShapes.getLeftLowerShape().check(x,y,r);
            }
        }
        if(x==0){
            if(y>0){
                return graphShapes.getRightUpperShape().check(x,y,r) || graphShapes.getLeftUpperShape().check(x,y,r);
            }
            if(y<0){
                return graphShapes.getLeftLowerShape().check(x,y,r) || graphShapes.getRightLowerShape().check(x,y,r);
            }
            if(y==0){
                return graphShapes.getRightLowerShape().check(x,y,r) || graphShapes.getRightUpperShape().check(x,y,r) || graphShapes.getLeftLowerShape().check(x,y,r) || graphShapes.getLeftUpperShape().check(x,y,r);
            }
        }
        return false;
    }
}
