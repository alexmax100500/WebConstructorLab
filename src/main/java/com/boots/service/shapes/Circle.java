package com.boots.service.shapes;

public class Circle implements Shape {

    public Circle(double r){
        this.r=r;
    }
    double r;

    @Override
    public boolean check(double x, double y) {
        return x*x+y*y<r*r;
    }

}
