package com.boots.service.shapes;

public class Emptiness implements Shape{
    @Override
    public boolean check(double x, double y, double r) {
        return false;
    }
}
