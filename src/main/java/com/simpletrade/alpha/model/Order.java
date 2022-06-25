package com.simpletrade.alpha.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "orders")
@Data
@NoArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String deviceName;
    private int memory;

    @OneToOne
    @JoinTable(name="order_status",joinColumns = @JoinColumn(name = "order_id"))
    private Status status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private User user;
    private String adress;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private PossibleModels phoneModel;

    public Order(int id, String adress) {
        this.id = id;
        this.adress = adress;
    }
}
