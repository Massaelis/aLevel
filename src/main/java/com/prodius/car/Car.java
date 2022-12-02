package com.prodius.car;

import com.prodius.model.Color;
import com.prodius.model.Engine;

import com.prodius.model.Type;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;
@Getter
@Setter
public abstract class Car {
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
}