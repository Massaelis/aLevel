package com.prodius.CarService;

import com.prodius.Car.Car;

import java.util.Random;

public class CarService {
    private static String randomString(){
        String symbols = "abcdefghijklmnopqrstuvwxyz";
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        int length = random.nextInt(5,8);
        for (int i = 0; i < length; i++) {
            sb.append(symbols.charAt(random.nextInt(symbols.length())));
        }
        return sb.toString();
    }

    public static Car create() {
        String manufacturer = randomString();
        String engine = randomString();
        String color = randomString();
        Car car = new Car(manufacturer, engine, color);
        return car;
    }

    public static void print(Car car){
        System.out.println("Manufacturer: " + car.getManufacturer() + " Engine: " + car.getEngine() + " Color: " +
                car.getColor() +" Count: " + car.getCount() + " Price: " + car.getPrice());
    }
}
