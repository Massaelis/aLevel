package com.prodius.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;
import java.util.UUID;
@Getter
@Setter
public abstract class Car implements CountRestore{
    private String manufacturer;
    private Engine engine;
    private Color color;
    protected int count;
    private int price;
    private String id;
    private Type type;

    public Car(){
        this.id = UUID.randomUUID().toString();
    }
    public Car(String manufacturer, Engine engine, Color color, Type type){
        this.manufacturer = manufacturer;
        this.engine = engine;
        this.color = color;
        this.count = 1;
        this.price = (int) (Math.random() * 9001 + 1000);
        this.id = UUID.randomUUID().toString();
        this.type = type;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(getId(), car.getId());
    }
    @Override
    public int hashCode() {
        return Objects.hash(getManufacturer(),getColor());
    }
}