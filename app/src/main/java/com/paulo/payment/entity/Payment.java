package com.paulo.payment.entity;


public class Payment {
    String type;

    public Payment(String name) {
        this.type = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


}