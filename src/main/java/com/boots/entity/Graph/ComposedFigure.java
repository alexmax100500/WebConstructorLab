package com.boots.entity.Graph;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.type.descriptor.sql.LobTypeMappings;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;

@Entity
@Table(name = "t_figure")
public class ComposedFigure {
    @Id
    @GeneratedValue
    private Long id;

    public Long getId() {
        return id;
    }

    public int getQuarter() {
        return quarter;
    }

    public String getPath() {
        return path;
    }

    public double getRx() {
        return rx;
    }

    public double getRy() {
        return ry;
    }

    public String getFigure() {
        return figure;
    }

    @Getter
    @Setter
    @Column(name = "type")
    private String figure;

    @Getter
    @Setter
    @Column(name = "quarter")
    private int quarter;
    @Getter
    @Setter
    @Column(name = "path")
    private String path;

    @Getter
    @Setter
    @Column(name = "rx")
    private double rx;

    @Getter
    @Setter
    @Column(name = "ry")
    private double ry;


    public ComposedFigure(String figure, int quarter, String path, double rx, double ry)
    {
        this.figure = figure;
        this.quarter = quarter;
        this.path = path;
        this.rx = rx;
        this.ry = ry;
    }
    public ComposedFigure(){}
}
