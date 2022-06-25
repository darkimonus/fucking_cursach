package com.simpletrade.alpha.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class ProcessedOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne
    Order order;

    String rating;

    @ManyToOne
    Condition condition;
}
