package com.example.carbon.domain;


import java.io.Serializable;


public class Processmodel implements Serializable {
    private int id;
    private String name;
    private String product;
    private String model;
    private String guige;
    private int unit;
    private int prow;
    private String notes;

    private String description;
    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getGuige() {
        return guige;
    }

    public void setGuige(String guige) {
        this.guige = guige;
    }

    public int getUnit() {
        return unit;
    }

    public void setUnit(int unit) {
        this.unit = unit;
    }

    public int getProw() {
        return prow;
    }

    public void setProw(int prow) {
        this.prow = prow;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public String toString() {
        return "Processmodel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", product='" + product + '\'' +
                ", model='" + model + '\'' +
                ", guige='" + guige + '\'' +
                ", unit=" + unit +
                ", prow=" + prow +
                ", notes='" + notes + '\'' +
                '}';
    }
}
