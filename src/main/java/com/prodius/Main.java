package com.prodius;

import com.prodius.car.Car;
import com.prodius.carService.CarService;
import com.prodius.repository.CarArrayRepository;

public class Main {
    public static void main(String[] args) {
        CarService carService = new CarService(new CarArrayRepository());
        Car car = carService.create();
        carService.print(car);
        carService.check(car);

        carService.printPassengerCar(carService.createPassengerCar());

        carService.printTruck(carService.createTruck());
    }
}