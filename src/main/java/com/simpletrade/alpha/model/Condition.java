package com.simpletrade.alpha.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "conditions")
@Data
public class Condition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    String name;
    String shortDescription;

}
