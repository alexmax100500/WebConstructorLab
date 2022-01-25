package com.boots.service.shapes;

public class Rectangular implements Shape {

    double rx, ry;

    public Rectangular(double rx, double ry){
        this.rx =  rx;
        this.ry = ry;
    }

    @Override
    public boolean check(double x, double y) {
        x=Math.abs(x);
        y=Math.abs(y);
        return x<=rx&&y<=ry;
    }

}
