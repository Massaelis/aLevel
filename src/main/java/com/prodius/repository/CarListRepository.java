package com.prodius.repository;

import com.prodius.model.Car;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.function.BiPredicate;

public class CarListRepository implements Repository<Car> {
    private static final List<Car> CARS = new LinkedList<>();

    private static CarListRepository instance;
    private static final BiPredicate<Car, String> CHECK_ID = (car, id) -> car.getId().equals(id);

    private CarListRepository() {
    }
    public static CarListRepository getInstance() {
        if (instance == null) {
            instance = new CarListRepository();
        }
        return instance;
    }
    @Override
    public void save(Car car) {
        CARS.stream()
                .filter(carsCar -> CHECK_ID.test(carsCar, car.getId()))
                .findAny()
                .ifPresentOrElse(
                        carsCar -> carsCar.setCount(car.getCount()),
                        () -> CARS.add(car)
                );
    }
    @Override
    public Optional<Car> getById(String id) {
        return CARS.stream()
                .filter(car -> CHECK_ID.test(car, id))
                .findAny();
    }
    @Override
    public Car[] getAll() {
        return CARS.toArray(new Car[0]);
    }
    @Override
    public void delete(String id) {
        CARS.removeIf(carsCar -> CHECK_ID.test(carsCar, id));
    }
}