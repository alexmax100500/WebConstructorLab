package com.boots.repository;

import com.boots.entity.Graph.ComposedFigure;
import com.boots.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.persistence.criteria.From;
import java.util.ArrayList;

public interface ComposedFigureRepository extends CrudRepository<ComposedFigure, Long> {
    //Достать целый кортеж по выбранному пути
    @Query("select cf FROM ComposedFigure cf where cf.path = ?1")
    ComposedFigure findByPath(String path);

    //Достать все результаты
    ArrayList<ComposedFigure> findAll();
}