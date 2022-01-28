package com.boots.service.shapes;

public class Triangle implements Shape {

    double ry, rx;

    public Triangle(double rx, double ry){
        this.rx=rx;
        this.ry=ry;
    }

    @Override
    public boolean check(double x, double y, double r) {
        x=Math.abs(x);
        y=Math.abs(y);
        return y<=-ry/rx*x-rx*r;
    }
}
