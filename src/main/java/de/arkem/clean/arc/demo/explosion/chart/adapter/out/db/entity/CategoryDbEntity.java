package de.arkem.clean.arc.demo.explosion.chart.adapter.out.db.entity;

import jakarta.persistence.Embeddable;

@Embeddable
public class CategoryDbEntity {
    private String name;
    private Integer number;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
}
