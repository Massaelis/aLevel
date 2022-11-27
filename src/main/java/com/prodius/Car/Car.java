package com.prodius.Car;

import com.prodius.model.Engine;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;
@Getter
@Setter
public class Car {
    private String manufacturer;
    private Engine engine;
    private Color color;
    private int count;
    private int price;
    private String id;

    public Car(){
        this.id = UUID.randomUUID().toString();
    }
    public Car(String manufacturer, Engine engine, Color color){
        this.manufacturer = manufacturer;
        this.engine = engine;
        this.color = color;
        this.count = 1;
        this.price = (int) (Math.random() * 9001 + 1000);
        this.id = UUID.randomUUID().toString();
    }
}
