package com.boots.service.shapes;

public class Circle implements Shape {

    public Circle(double r){
        this.r1=r;
    }
    double r1;

    @Override
    public boolean check(double x, double y, double r) {
        x=Math.abs(x);
        y=Math.abs(y);
        return x*x+y*y<r*r*r1*r1;
    }

}
