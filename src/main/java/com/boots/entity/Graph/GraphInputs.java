package com.boots.entity.Graph;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.management.openmbean.ArrayType;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "t_StoredInputs")
public class GraphInputs {
    @Id
    @GeneratedValue
    private Long id;

    @Getter
    @Setter
    @Enumerated(EnumType.STRING)
    @Column(name="inputType")
    private InputType inputType;

    @Getter
    @Setter
    @ElementCollection
    @Column(name="values")
    private List<Double> values;


}
