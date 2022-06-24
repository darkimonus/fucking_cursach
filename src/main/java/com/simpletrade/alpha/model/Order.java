package com.simpletrade.alpha.model;

import javax.persistence.*;

@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String deviceName;
    private int memory;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "auth_user_id")
    private User user;
    private String adress;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    private PossibleModels phoneModel;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public int getMemory() {
        return memory;
    }

    public void setMemory(int memory) {
        this.memory = memory;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public PossibleModels getPhoneModel() {
        return phoneModel;
    }

    public void setPhoneModel(PossibleModels phoneModel) {
        this.phoneModel = phoneModel;
    }
}
