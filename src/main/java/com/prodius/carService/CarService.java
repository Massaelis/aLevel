package com.prodius.carService;

import com.prodius.model.Car;
import com.prodius.exeption.UserInputException;
import com.prodius.model.Color;
import com.prodius.model.Engine;
import com.prodius.model.PassengerCar;
import com.prodius.model.Truck;
import com.prodius.model.Type;
import com.prodius.repository.CarArrayRepository;
import com.prodius.util.RandomGenerator;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.prodius.util.RandomGenerator.getRandomType;

public class CarService {
    private static CarService carService;
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
    public Car createCar(final Type type) {
        Car car;
        if (type == Type.CAR) {
            car = new PassengerCar(randomString(), getRandomEngine(), getRandomColor(), getRandomType());
            ((PassengerCar)car).setPassengerCount(RandomGenerator.getRandomNumber());
        } else if (type == Type.TRUCK) {
            car = new Truck(randomString(), getRandomEngine(), getRandomColor(), getRandomType());
            ((Truck)car).setLoadCapacity(RandomGenerator.getRandomNumber());
        } else {
            car = null;
        }
        return car;
    }
    public void printCar(Car car) {
        if (car == null) {
            return;
        }
        System.out.print("id: " + car.getId() + "; Type car: " + car.getType() +"; Manufacturer: "
                + car.getManufacturer() + "; Engine: " + car.getEngine() + "; Color: "
                + car.getColor() +"; Count: " + car.getCount() + "; Price: " + car.getPrice());
        if(car.getType() == Type.CAR){
            System.out.println("; PassengerCount " + ((PassengerCar)car).getPassengerCount());
        } else {
            System.out.println("; LoadCapacity: " + ((Truck)car).getLoadCapacity());
        }
        System.out.println();
    }
    public boolean carEquals(Car car1, Car car2) {
        if (car1 == null || car2 == null){
            return false;
        }
        if (car1 == car2){
            return true;
        }
        if (car2.getType() != car1.getType()){
            return false;
        }
        if (car1.hashCode() != car2.hashCode()){
            return false;
        }
        return car1.equals(car2);
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
    public void printManufacturerAndCount(final Car car) {
        Optional.ofNullable(car).ifPresent(manufacturerAndCount -> System.out.println("Manufacturer and Count: "
                + car.getManufacturer() + ", " + car.getCount()));
    }
    public void printColor(final Car car) {
        System.out.println("Color: " + Optional.ofNullable(car).orElse(createCar(Type.CAR)).getColor());
    }
    public void checkCount(final Car car) {
        Car carA = Optional.ofNullable(car).filter(x -> x.getCount() > 10).orElseThrow(() ->
                new UserInputException("Count: 10 or less"));
        System.out.println("Manufacturer and Count: " + carA.getManufacturer() + ", " + carA.getCount());
    }
    public void printEngineInfo(final Car car) {
        Car carA = Optional.ofNullable(car).orElseGet(()->{
            System.out.println("Create car");
            return createCar(Type.CAR);
        });
        Optional.ofNullable(car).map(Car::getEngine).ifPresent(power -> System.out.println("Engine: " + carA.getEngine()));
    }
    public void printInfo(final Car car){
        Optional.ofNullable(car).ifPresentOrElse(print -> printCar(car), () -> printCar(createCar(Type.CAR)));
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
    public static CarService getInstance() {
        if (carService == null) {
            return new CarService(CarArrayRepository.getInstance());
        }
        return carService;
    }
    public Map<String, Integer> MapManufactureCount(List<Car> cars) {
        return cars.stream().collect(Collectors.toMap(Car::getManufacturer, Car::getCount));
    }
    public Map<Integer, Car> MapEnginePower(List<Car> cars) {
        return cars.stream().collect(Collectors.toMap(car -> car.getEngine().getPower(), car -> car));
    }
    public Map<Engine.TypeEngine, List<Car>> MapEngineType(List<Car> cars) {
        return cars.stream().collect(Collectors.toMap(car -> car.getEngine().getType(), List::of,
                (a, b) -> Stream.concat(a.stream(), b.stream()).collect(Collectors.toList())));
    }
}