package com.boots.entity;

import com.boots.entity.Graph.FigureType;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


public class ReadyFigures {
    private String figureType;
    @Getter
    @Setter
    private int quarter;
    private String path;

    public ReadyFigures(String figureType, int quarter, String path)
    {
        this.figureType = figureType;
        this.quarter = quarter;
        this.path = path;
    }
    public String getFigureType(){return figureType;}
    public int getRotationDegree(){return quarter;}
    public String getPath(){return path;}

    public void setFigureType(FigureType String) {this.figureType = figureType;}
    public void setRotationDegree(int rotationDegree){this.quarter = quarter;}
    public void setPath(String path){this.path = path;}
}
