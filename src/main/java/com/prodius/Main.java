package com.prodius;

import com.prodius.car.Car;
import com.prodius.carService.CarService;
import com.prodius.container.CarList;
import com.prodius.container.GenericContainer;
import com.prodius.model.Type;
import com.prodius.repository.CarArrayRepository;
import com.prodius.util.AlgorithmUtil;
import com.prodius.util.RandomGenerator;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        CarService carService = new CarService(new CarArrayRepository());
        Car car1 = carService.createCar(RandomGenerator.getRandomType());
        /*
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

        GenericContainer<Car> genericContainer = new GenericContainer<>(carService.createCar(Type.CAR));
        genericContainer.print();
        genericContainer.increaseCount();
        genericContainer.print();
        genericContainer.increaseCount(15);
        genericContainer.print();
         */
        Car car2 = carService.createCar(RandomGenerator.getRandomType());
        Car car3 = carService.createCar(RandomGenerator.getRandomType());
        Car car4 = carService.createCar(RandomGenerator.getRandomType());

        CarList<Car> list = new CarList<>();
        list.addLast(car3);
        list.addLast(car2);
        list.addLast(car1);
        list.addLast(carService.createCar(Type.CAR));

        System.out.println(list.getSize());
        list.addFirst(carService.createCar(Type.CAR));
        list.addLast(null);
        list.delete(5);
        list.insert(car4,0);

        System.out.println(list.findByValue(car1));

        System.out.println(list.getSize());

        System.out.println();
        for (Car car : list) {
            System.out.println("---");
            System.out.println(car);
            System.out.println(list.totalCount());
        }
    }
}