package com.simpletrade.alpha.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PossibleModels {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    private String memory;

    private int maxPrice;

    private int minPrice;

    public String getMemory() {
        return memory;
    }

    public void setMemory(String memory) {
        this.memory = memory;
    }

    public int getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(int maxPrice) {
        this.maxPrice = maxPrice;
    }

    public int getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(int minPrice) {
        this.minPrice = minPrice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
