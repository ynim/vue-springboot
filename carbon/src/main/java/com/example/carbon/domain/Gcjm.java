package com.example.carbon.domain;

import java.io.Serializable;

public class Gcjm implements Serializable {
    private int id;
    private String product;
    private String scxname;

    public String getScxname() {
        return scxname;
    }

    public void setScxname(String scxname) {
        this.scxname = scxname;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "gcjm{" +
                "id=" + id +
                ", product='" + product + '\'' +
                ", scxname='" + scxname + '\'' +
                '}';
    }
}
