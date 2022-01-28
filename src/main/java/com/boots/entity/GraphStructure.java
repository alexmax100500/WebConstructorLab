package com.boots.entity;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;

import java.util.LinkedList;
import java.util.List;
@Service
@ApplicationScope
public class GraphStructure<E> extends LinkedList<E> {

}
