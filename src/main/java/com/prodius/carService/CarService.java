package com.prodius.carService;

import com.prodius.car.Car;
import com.prodius.model.Color;
import com.prodius.model.Engine;
import com.prodius.model.PassengerCar;
import com.prodius.model.Truck;
import com.prodius.model.Type;
import com.prodius.repository.CarArrayRepository;
import com.prodius.util.RandomGenerator;

import java.util.Random;

public class CarService {
    private final Random random = new Random();

    public PassengerCar create() {
        PassengerCar car = new PassengerCar(randomString(), getRandomEngine(), getRandomColor(), Type.CAR);
        carArrayRepository.save(car);
        return car;
    }
    public PassengerCar createPassengerCar() {
        PassengerCar passengerCar = new PassengerCar(randomString(), getRandomEngine(), getRandomColor(), Type.CAR);
        carArrayRepository.save(passengerCar);
        return passengerCar;
    }
    public Truck createTruck() {
        final Truck truck = new Truck(randomString(), getRandomEngine(), getRandomColor(), Type.TRUCK);
        carArrayRepository.save(truck);
        return truck;
    }
    public void printPassengerCar(PassengerCar passengerCar) {
        if (passengerCar == null) {
            return;
        }
        System.out.println("id: " + passengerCar.getId() + "; Type car: " + passengerCar.getType() +"; Manufacturer: "
                + passengerCar.getManufacturer() + "; Engine: " + passengerCar.getEngine() + "; Color: "
                + passengerCar.getColor() + "; Count: " + passengerCar.getCount() + "; PassengerCount: "
                + passengerCar.getPassengerCount());
    }
    public void printTruck(Truck truck) {
        if (truck == null) {
            return;
        }
        System.out.println("id: " + truck.getId() + "; Type car: " + truck.getType() +"; Manufacturer: "
                + truck.getManufacturer() + "; Engine: " + truck.getEngine() + "; Color: "
                + truck.getColor() + "; Count: " + truck.getCount() + "; LoadCapacity: "
                + truck.getLoadCapacity());
    }

    public int create(final int count) {
        if (count <= 0) {
            return -1;
        }
        for (int i = 0; i < count; i++) {
            create();
        }
        return count;
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
        final Color[] colors = Color.values();
        return colors[random.nextInt(colors.length)];
    }
    private Engine getRandomEngine() {
        final Engine.TypeEngine[] type = Engine.TypeEngine.values();
        return new Engine(type[random.nextInt(type.length)], random.nextInt(0, 1001));
    }
    public void print(Car car) {
        System.out.println("id: " + car.getId() +"; Type car: " + car.getType() +"; Manufacturer: "
                + car.getManufacturer() + "; Engine: " + car.getEngine() + "; Color: " + car.getColor() + "; Count: "
                + car.getCount() + "; Price: " + car.getPrice());
    }
    public static void check(Car car) {
        if (car == null) {
            return;
        }
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
    public CarService(final CarArrayRepository carArrayRepository) {
        this.carArrayRepository = carArrayRepository;
    }
    private final CarArrayRepository carArrayRepository;

    public int create(final RandomGenerator randomGenerator) {
        if (randomGenerator == null) {
            return -1;
        }
        int count = randomGenerator.getRandomNumber();
        if (count <= 0) {
            return -1;
        }
        create(count);
        printAll();
        return count;
    }
    public void printAll() {
        for (Car car : getAll()) {
            System.out.println(car);
        }
    }
    public Car find(final String id) {
        if (id == null || id.isEmpty()) {
            return null;
        }
        return carArrayRepository.getById(id);
    }
    public Car[] getAll() {
        return carArrayRepository.getAll();
    }
    public void delete(final String id) {
        if (id == null || id.isEmpty()) {
            return;
        }
        carArrayRepository.delete(id);
    }
    public void insertCar(final int index, final Car car) {
        carArrayRepository.insert(index, car);
    }
}