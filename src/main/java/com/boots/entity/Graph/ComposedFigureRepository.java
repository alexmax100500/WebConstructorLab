package com.boots.entity.Graph;

import com.boots.entity.Graph.ComposedFigure;
import com.boots.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.persistence.criteria.From;
import java.util.ArrayList;

public interface ComposedFigureRepository extends CrudRepository<ComposedFigure, Long> {
    //Достать одну фигуру из бд
    @Query("select cf FROM ComposedFigure cf where cf.path = ?1 and cf.figure = ?2")
    ComposedFigure findByPathAndFigure(String path, FigureType figureType);

    //Достать все результаты
    @Query(value = "select * From t_figure",
            nativeQuery = true)
    ArrayList<ComposedFigure> getAll();
}