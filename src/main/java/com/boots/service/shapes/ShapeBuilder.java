package com.boots.service.shapes;

import org.springframework.stereotype.Service;

@Service
public class ShapeBuilder {
    public Shape createShape(String type, double rx, double ry){
        Shape shape;
        switch(type) {
            case "emptiness":
                shape = new Emptiness();
                break;
            case "circle":
                shape = new Circle(rx);
                break;
            case "square":
                shape = new Rectangular(rx, ry);
                break;
            case "triangle":
                shape = new Triangle(rx, ry);
                break;
            default:
                shape = new Emptiness();
                break;
        }
        return shape;
    }
}
