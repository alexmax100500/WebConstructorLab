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


    public ComposedFigure(String figure, int quarter, String path)
    {
        this.figure = figure;
        this.quarter = quarter;
        this.path = path;
    }
    public ComposedFigure(){}
}
