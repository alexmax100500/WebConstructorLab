package com.boots.entity.Graph;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.type.descriptor.sql.LobTypeMappings;

import javax.persistence.*;

@Entity
@Table(name = "t_figure")
public class ComposedFigure {
    @Id
    private Long id;

    @Getter
    @Setter
    @Column(name = "path")
    private String path;

    @Getter
    @Setter
    @Column(name = "type")
    private String figure;

    public ComposedFigure(FigureType ft, byte imNum, byte secNum)
    {
        this.figure = ft.toString().toLowerCase();
    }
    public ComposedFigure(){}
}
