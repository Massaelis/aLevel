package com.prodius.repository;

import com.prodius.car.Car;
import com.prodius.carService.CarService;
import com.prodius.model.Color;

public class CarArrayRepository implements Repository<Car> {
    private static CarArrayRepository carArrayRepository;
    private static Car[] cars = new Car[10];

    public void save(final Car car){
        final int index = putCar(car);
        if (index == cars.length){
            final int oldLength = cars.length;
            increaseArray();
            cars[oldLength] = car;
        }
    }
    public Car[] getAll() {
        final int newLength = foundLength();
        final Car[] newCar = new Car[newLength];
        System.arraycopy(cars, 0, newCar, 0, newLength);
        return newCar;
    }
    public Car getById(final String id) {
        for (Car car : cars) {
            if (car.getId().equals(id)) {
                return car;
            }
        }
        return null;
    }
    public void delete(final String id) {
        int index = 0;
        for (; index < cars.length; index++) {
            if (cars[index].getId().equals(id)) {
                break;
            }
        }
        if (index != cars.length) {
            System.arraycopy(cars, index + 1, cars, index,
                    cars.length - (index + 1));
        }
    }
    public void insert(int index, final Car car) {
        if (cars[cars.length - 1] != null) {
            increaseArray();
        }
        final int newLength = foundLength();
        if (index > newLength) {
            putCar(car);
        } else {
            System.arraycopy(cars, index, cars, index+1,
                    cars.length - (index + 1));
            cars[index]=car;
        }
    }
    public void updateColor(final String id, final Color color) {
        final Car car = getById(id);
        if (car != null) {
            car.setColor(color);
        }
    }
    private int foundLength() {
        int newLength = 0;
        for (Car car : cars){
            if (car != null){
                newLength++;
            }else{
                break;
            }
        }
        return newLength;
    }
    private int putCar(final Car car){
        int index = 0;
        for (;index < cars.length; index++){
            if (cars[index] == null){
                cars[index] = car;
                break;
            }
        }
        return index;
    }
    private void increaseArray(){
        Car[] newCar = new Car[cars.length * 2];
        System.arraycopy(cars, 0, newCar, 0, cars.length);
        cars = newCar;
    }
    public static CarArrayRepository getInstance() {
        cars = new Car[10];
        if (carArrayRepository == null) {
            return new CarArrayRepository();
        }
        return carArrayRepository;
    }
}

