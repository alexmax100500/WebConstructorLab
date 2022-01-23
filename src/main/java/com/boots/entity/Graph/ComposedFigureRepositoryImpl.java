package com.boots.entity.Graph;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ComposedFigureRepositoryImpl {
    @Autowired
    private ComposedFigureRepository repository;

    public ComposedFigure findByPFT(String path, FigureType figureType) {
        return repository.findByPathAndFigure(path,figureType);
    }
    public ArrayList<ComposedFigure> returnAll() {
        return repository.getAll();
    }
}
