package com.prodius.model;

import com.prodius.util.RandomGenerator;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Truck extends Car{
    private int loadCapacity;
    public Truck(){
    }
    public Truck(String manufacturer, Engine engine, Color color, Type type) {
        super(manufacturer, engine, color, type);
        super.setType(Type.TRUCK);
        super.setCount(50);
        this.setLoadCapacity(RandomGenerator.getRandomNumber());
    }
    @Override
    public void restore() {
        super.setCount(50);
        System.out.println("Count: " + count);
    }
}
