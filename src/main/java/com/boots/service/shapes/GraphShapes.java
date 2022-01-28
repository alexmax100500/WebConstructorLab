package com.boots.service.shapes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;

@Service("GraphShapes")
@ApplicationScope
public class GraphShapes {
    Shape leftUpperShape= new Emptiness();
    Shape leftLowerShape = new Emptiness();
    Shape rightUpperShape = new Emptiness();
    Shape rightLowerShape = new Emptiness();

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
