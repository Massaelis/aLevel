package com.prodius.CarService;

import com.prodius.Car.Car;
import com.prodius.Car.Color;
import com.prodius.model.Engine;

import java.util.Random;

public class CarService {
    private Random random = new Random();

    public Car create() {
        String manufacturer = randomString();
        Car car = new Car(manufacturer, getRandomEngine(), getRandomColor());

        return car;
    }

    private String randomString() {
        String symbols = "abcdefghijklmnopqrstuvwxyz";
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        int length = random.nextInt(5, 8);
        for (int i = 0; i < length; i++) {
            sb.append(symbols.charAt(random.nextInt(symbols.length())));
        }
        return sb.toString();
    }

    private Color getRandomColor() {
        final Color[] values = Color.values();
        final int randomIndex = random.nextInt(values.length);
        return values[randomIndex];
    }

    private Engine getRandomEngine() {
        final Engine.TypeEngine[] type = Engine.TypeEngine.values();
        return new Engine(type[random.nextInt(type.length)], random.nextInt(0, 1001));
    }

    public void print(Car car) {
        System.out.println("Manufacturer: " + car.getManufacturer() + " Engine: " + car.getEngine() + " Color: " +
                car.getColor() + " Count: " + car.getCount() + " Price: " + car.getPrice());
    }

    public void check(Car car) {
        if (car.getCount() < 1 && car.getEngine().getPower() > 200) {
            System.out.println("Power is more than 200, but car is not available");
        } else if (car.getCount() >= 1 && car.getEngine().getPower() < 200) {
            System.out.println("The car is available, but engine power is less than 200");
        } else if (car.getCount() >= 1 && car.getEngine().getPower() > 200) {
            System.out.println("Car is ready for sell");
        } else {
            System.out.println("Power and count less that need");
        }
    }
}
