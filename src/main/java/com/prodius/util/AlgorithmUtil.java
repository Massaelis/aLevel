package com.prodius.util;

import com.prodius.car.Car;

import java.util.HashMap;
import java.util.Map;

public class AlgorithmUtil {
    public static Car[] bubbleSort(Car[] cars) {
        Map<String, Car> map = new HashMap<>();
        Car[] sortedCars = new Car[cars.length];
        for (Car car : cars) {
            map.put(car.getId(), car);
        }
        String[] id = map.keySet().toArray(new String[0]);
        int compare;
        for (int i = 0; i < id.length - 1; i++) {
            for (int j = 0; j < id.length - i - 1; j++) {
                compare = id[j].compareTo(id[j + 1]);
                if (compare > 0) {
                    String forSwap = id[j + 1];
                    id[j + 1] = id[j];
                    id[j] = forSwap;
                }
            }
        }
        for (int i = 0; i < sortedCars.length; i++) {
            sortedCars[i] = map.get(id[i]);
        }
        return sortedCars;
    }
    public static int binarySearch(Car[] cars, Car car, int firstElement, int lastElement) {
        int midIndex = firstElement + (lastElement - firstElement)/2;
        int compare = car.getId().compareTo(cars[midIndex].getId());
        if (compare == 0) {
            return midIndex;
        } else if (compare < 0) {
            return binarySearch(cars, car, firstElement, midIndex - 1);
        } else {
            return binarySearch(cars, car, midIndex + 1, lastElement);
        }
    }
}