package com.prodius.service;

import com.prodius.model.Car;
import com.prodius.carService.CarService;
import com.prodius.model.PassengerCar;
import com.prodius.repository.CarArrayRepository;
import com.prodius.util.RandomGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class CarServiceTest {
    private CarService target;
    private CarArrayRepository repository;
    private RandomGenerator randomGenerator;
    private PassengerCar car;;
    @BeforeEach
    void setUp() {
        repository = Mockito.mock(CarArrayRepository.class);
        target = new CarService(repository);
        randomGenerator = Mockito.mock(RandomGenerator.class);
        car = new PassengerCar();
    }

    @Test
    void create_not_null() {
        final Car car = target.create();
        Assertions.assertNotNull(car);
    }

    @Test
    void create_with_random_positive() {
        Mockito.when(randomGenerator.getRandomNumber()).thenReturn(3);
        final int realCount = target.create(randomGenerator);
        final int expectedCount = 3;
        Assertions.assertEquals(expectedCount, realCount);
    }

    @Test
    void create_with_random_negative() {
        Mockito.when(randomGenerator.getRandomNumber()).thenReturn(-3);
        final int realCount = target.create(randomGenerator);
        final int expectedCount = -1;
        Assertions.assertEquals(expectedCount, realCount);
    }

    @Test
    void create_with_null_random_generator() {
        final int expectedCount = -1;
        randomGenerator = null;
        final int realCount = target.create(randomGenerator);
        Assertions.assertEquals(expectedCount, realCount);
    }

    @Test
    void create_with_positive_count() {
        final int count = 7;
        final int realCount = target.create(count);
        final int expectedCount = 7;
        Assertions.assertEquals(expectedCount, realCount);
    }
    @Test
    void create_with_negative_count() {
        final int count = -7;
        final int realCount = target.create(count);
        final int expectedCount = -1;
        Assertions.assertEquals(expectedCount, realCount);
    }

    @Test
    void create_with_zero_count() {
        final int count = 0;
        final int realCount = target.create(count);
        final int expectedCount = -1;
        Assertions.assertEquals(expectedCount, realCount);
    }

    @Test
    void getAll_does_not_throw() {
        Assertions.assertDoesNotThrow(() -> target.getAll());
    }

    @Test
    void getAll_is_null() {
        Assertions.assertNull(target.getAll());
    }

    @Test
    void getAll_not_null() {
        final Car[] cars = {new PassengerCar(), new PassengerCar()};
        Mockito.when(repository.getAll()).thenReturn(cars);
        Assertions.assertNotNull(target.getAll());
    }

    @Test
    void find_with_null_id() {
        Assertions.assertNull(target.find(null));
    }

    @Test
    void find_with_empty_id() {
        Assertions.assertNull(target.find("    "));
    }
    @Test
    void find_not_null() {
        Mockito.when(repository.getById("random")).thenReturn(car);
        Car car = target.find("random");
        Assertions.assertNotNull(car);
    }
    @Test
    void delete_with_positive() {
        Assertions.assertDoesNotThrow(() -> target.delete("random"));
    }

    @Test
    void delete_with_null_id() {
        Assertions.assertDoesNotThrow(() -> target.delete(null));
    }

    @Test
    void delete_with_empty_id() {
        Assertions.assertDoesNotThrow(() -> target.delete("     "));
    }

    @Test
    void insertCar_with_positive() {
        int randomIndex = 7;
        Assertions.assertDoesNotThrow(() -> target.insertCar(randomIndex, car));
    }
    @Test
    void insertCar_with_incorrect_index() {
        int randomIndex = -3;
        Assertions.assertDoesNotThrow(() -> target.insertCar(randomIndex, car));
    }
    @Test
    void insertCar_null_car() {
        int randomIndex = 4;
        Assertions.assertDoesNotThrow(() -> target.insertCar(randomIndex, null));
    }

    @Test
    void check_with_positive() {
        Assertions.assertDoesNotThrow(() -> CarService.check(car));
    }

    @Test
    void check_with_null_car() {
        Assertions.assertDoesNotThrow(() -> CarService.check(null));
    }

    @Test
    void printAll() {
        Assertions.assertDoesNotThrow(() -> target.printAll());
    }
    @Test
    void carEquals_with_null_car() {
        final boolean expected = false;
        boolean realValue = target.carEquals(car, null);
        Assertions.assertEquals(expected, realValue);
    }
    @Test
    void carEquals_with_same_car() {
        final boolean expected = true;
        boolean realValue = target.carEquals(car, car);
        Assertions.assertEquals(expected, realValue);
    }
    @Test
    void printManufacturerAndCount_null() {
        Assertions.assertDoesNotThrow(() -> target.printManufacturerAndCount(null));
    }
    @Test
    void printManufacturerAndCount_positive() {
        Assertions.assertDoesNotThrow(() -> target.printManufacturerAndCount(car));
    }
    @Test
    void printColor_null() {
        Assertions.assertDoesNotThrow(() -> target.printColor(null));
    }
    @Test
    void printColor_positive() {
        Assertions.assertDoesNotThrow(() -> target.printColor(car));
    }
    @Test
    void printEngineInfo_null() {
        Assertions.assertDoesNotThrow(() -> target.printEngineInfo(null));
    }
    @Test
    void printEngineInfo_positive() {
        Assertions.assertDoesNotThrow(() -> target.printEngineInfo(car));
    }
}