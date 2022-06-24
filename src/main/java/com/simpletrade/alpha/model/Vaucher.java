package com.simpletrade.alpha.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

public class Vaucher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    String shopName;
    @OneToOne
    ProcessedOrder processedOrder;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public ProcessedOrder getProcessedOrder() {
        return processedOrder;
    }

    public void setProcessedOrder(ProcessedOrder processedOrder) {
        this.processedOrder = processedOrder;
    }
}
