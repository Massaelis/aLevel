package com.prodius;

import com.prodius.car.Car;
import com.prodius.carService.CarService;
import com.prodius.repository.CarArrayRepository;
import com.prodius.util.AlgorithmUtil;
import com.prodius.util.RandomGenerator;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        CarService carService = new CarService(new CarArrayRepository());
        Car carA = carService.createCar(RandomGenerator.getRandomType());
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

        carService.printManufacturerAndCount(carA);
        carService.printColor(carA);
        carService.checkCount(carA);
        carService.printEngineInfo(carA);
        carService.printInfo(carA);

        CarService carServiceX = CarService.getInstance();
        carServiceX.create(5);
        carServiceX.printAll();
        Car[] sortedCars = AlgorithmUtil.bubbleSort(carServiceX.getAll());
        System.out.println(Arrays.toString(sortedCars));
        int index = AlgorithmUtil.binarySearch(sortedCars, sortedCars[1], 0, sortedCars.length);
        System.out.println(sortedCars[index]);
    }
}