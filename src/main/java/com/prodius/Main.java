package com.prodius;

import com.prodius.car.Car;
import com.prodius.carService.CarService;
import com.prodius.repository.CarArrayRepository;
import com.prodius.util.RandomGenerator;

public class Main {
    public static void main(String[] args) {
        CarService carService = new CarService(new CarArrayRepository());
        Car car = carService.create();
        carService.print(car);
        carService.check(car);

        carService.printPassengerCar(carService.createPassengerCar());

        carService.printTruck(carService.createTruck());
        System.out.println();
        Car car1 = carService.createCar(RandomGenerator.getRandomType());
        carService.printCar(car1);
        Car car2 = carService.createCar(RandomGenerator.getRandomType());
        carService.printCar(car2);
        System.out.println(carService.carEquals(car1, car2));
    }
}