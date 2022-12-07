package com.prodius.model;

import com.prodius.car.Car;
import com.prodius.util.RandomGenerator;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PassengerCar extends Car{

    private int passengerCount;

    public PassengerCar() {
    }
    public PassengerCar(String manufacturer, Engine engine, Color color, Type type){
        super(manufacturer, engine, color, type);
        super.setType(Type.CAR);
        super.setCount(100);
        this.setPassengerCount(RandomGenerator.getRandomNumber());
    }
    @Override
    public void restore() {
        super.setCount(100);
        System.out.println("Count: " + count);
    }
}