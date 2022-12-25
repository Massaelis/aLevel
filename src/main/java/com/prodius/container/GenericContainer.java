package com.prodius.container;

import com.prodius.model.Car;
import com.prodius.carService.CarService;

import java.util.Random;

public class GenericContainer <T extends Car>{
    private final Random random = new Random();
    private final CarService carService = CarService.getInstance();
    private final T t;
    public GenericContainer(T t){
        this.t = t;
    }
    public void print(){
        carService.printInfo(t);
    }
    public void increaseCount(){
        t.setCount(t.getCount() + random.nextInt(100,301));
    }
    public <V extends Number> void increaseCount(V number){
        t.setCount(t.getCount() + number.intValue());
    }
}
