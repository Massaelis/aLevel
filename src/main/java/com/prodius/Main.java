package com.prodius;

import com.prodius.Car.Car;
import com.prodius.CarService.CarService;
import com.prodius.repository.CarArrayRepository;

public class Main {
    public static void main(String[] args) {
        CarService carService = new CarService(new CarArrayRepository());
        Car car1 = carService.create();
        Car car2 = carService.create();
        Car car3 = carService.create();
        carService.print(car1);
        carService.print(car2);
        carService.print(car3);

        carService.check(car1);
        carService.check(car2);
        carService.check(car3);
    }
}