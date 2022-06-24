package com.simpletrade.alpha.model;

public class CourierOrder {
     private int id;
     private String status;
     private String adress;

     public CourierOrder() {
     }

     public CourierOrder(int id, String status, String adress) {
          this.id = id;
          this.status = status;
          this.adress = adress;
     }

     public int getId() {
          return id;
     }

     public void setId(int id) {
          this.id = id;
     }

     public String getStatus() {
          return status;
     }

     public void setStatus(String status) {
          this.status = status;
     }

     public String getAdress() {
          return adress;
     }

     public void setAdress(String adress) {
          this.adress = adress;
     }
}
