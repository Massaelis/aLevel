package com.prodius;

import com.prodius.container.CarComparator;
import com.prodius.container.CarTree;
import com.prodius.model.Car;
import com.prodius.carService.CarService;
import com.prodius.model.Color;
import com.prodius.model.Engine;
import com.prodius.model.Type;
import com.prodius.repository.CarArrayRepository;
import com.prodius.util.RandomGenerator;

import java.util.*;

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
        /*
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
         */
        /*
        carService.create();
        List<Car> cars = Arrays.asList(carService.getAll());
        Car car2 = carService.createCar(RandomGenerator.getRandomType());
        carService.printCar(car1);
        carService.printCar(car2);

        System.out.print("Car Compare: ");
        CarComparator<Car> carComparator = new CarComparator<>();
        System.out.println(carComparator.compare(car1, car2));

        System.out.print("Binary tree: ");
        CarTree<Car> carTree = new CarTree<>();
        for(int i = 0; i < 10; i++) {
            Car car = carService.createCar(RandomGenerator.getRandomType());
            carTree.insertNode(car);
            System.out.print(car.getCount() + ", ");
        }

        System.out.println();
        System.out.print("Count:");
        System.out.println("left count: " + carTree.getLeftCount()
                + " and " + "right count: " + carTree.getRightCount());

        System.out.print("Map Manufacturer: ");
        Map<String, Integer> stringCarMap = carService.mapManufactureCount(cars);
        System.out.println(stringCarMap);

        System.out.print("Map Engine Power: ");
        Map<Integer, Car> integerCarMap = carService.mapEnginePower(cars);
        System.out.println(integerCarMap);

        System.out.print("Map Engine  Type: ");
        Map<Engine.TypeEngine, List<Car>> engineListMap = carService.mapEngineType(cars);
        System.out.println(engineListMap);
         */
        List<Car> cars = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            Car car = carService.createCar(RandomGenerator.getRandomType());
            cars.add(car);
        }
        System.out.println("Manufacturer By Price more 5000: " + carService.findManufacturerByPrice(cars, 5000));
        System.out.println("Count Sum: " + carService.countSum(cars));
        System.out.println("Map: " + carService.mapToMap(cars));
        System.out.println("Statistic: " + carService.statistic(cars));
        System.out.println("Price higher 1000$: " + carService.priceCheck(cars, 1000));


        Map<String, Object> mapConfig = new HashMap<>();
        mapConfig.put("Type", Type.CAR);
        mapConfig.put("Manufacturer", carService.randomString());
        mapConfig.put("Color", Color.PURPLE);
        mapConfig.put("Price", 2000);
        Car newCar = carService.mapToObject(mapConfig);
        carService.printCar( newCar);

        List<List<Car>> listsCars = new ArrayList<>();
        listsCars.add(cars);
        Map<Color, Long> mapFiltered = carService.innerList(listsCars, 1000);
        System.out.println(mapFiltered);
    }
}