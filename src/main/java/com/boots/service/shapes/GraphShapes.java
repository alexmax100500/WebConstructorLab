package com.boots.service.shapes;

import org.springframework.stereotype.Service;

@Service
public class GraphShapes {
    Shape leftUpperShape;
    Shape leftLowerShape;
    Shape rightUpperShape;
    Shape rightLowerShape;

    public void setLeftLowerShape(Shape leftLowerShape) {
        this.leftLowerShape = leftLowerShape;
    }

    public void setRightUpperShape(Shape rightUpperShape) {
        this.rightUpperShape = rightUpperShape;
    }

    public void setRightLowerShape(Shape rightLowerShape) {
        this.rightLowerShape = rightLowerShape;
    }

    public void setLeftUpperShape(Shape leftUpperShape) {
        this.leftUpperShape = leftUpperShape;
    }

    public Shape getLeftUpperShape() {
        return leftUpperShape;
    }

    public Shape getLeftLowerShape() {
        return leftLowerShape;
    }

    public Shape getRightUpperShape() {
        return rightUpperShape;
    }

    public Shape getRightLowerShape() {
        return rightLowerShape;
    }

}
