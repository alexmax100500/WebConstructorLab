package com.boots.service.shapes;

import org.springframework.stereotype.Service;

@Service
public class ShapeBuilder {
    public Shape createShape(int type, double rx, double ry){
        Shape shape;
        switch(type) {
            case 0:
                shape = new Emptiness();
                break;
            case 1:
                shape = new Circle(rx);
                break;
            case 2:
                shape = new Rectangular(rx, ry);
                break;
            case 3:
                shape = new Triangle(rx, ry);
                break;
            default:
                shape = new Emptiness();
                break;
        }
        return shape;
    }
}
