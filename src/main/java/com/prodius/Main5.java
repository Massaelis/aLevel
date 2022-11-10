package com.prodius;

import java.util.Arrays;
import java.util.Random;

public class Main5 {
    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
        bubbleSort();
    }
    private static void test1() {
        Random random = new Random();
        int[] numbers = new int[12];
        int maxNumbers = numbers[0];
        int maxIndex = 0;
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = random.nextInt(-15, 15);
            if (maxNumbers <= numbers[i]) {
                maxNumbers = numbers[i];
                maxIndex = i;
            }
        }
        System.out.println(Arrays.toString(numbers));
        System.out.println("Максимальное число: " + maxNumbers);
        System.out.println("Индекс: " + maxIndex);
    }

    private static void test2() {
        Random random = new Random();
        int[] numbers = new int[8];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = random.nextInt(1, 10);
        }
        System.out.println(Arrays.toString(numbers));
        for (int i = 0; i < numbers.length; i++) {
            if (i % 2 == 1) {
                numbers[i] = 0;
            }
        }
        System.out.println(Arrays.toString(numbers));
    }

    private static void test3() {
        Random random = new Random();
        int[] numbers = new int[4];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = random.nextInt(10, 99);
        }
        System.out.println(Arrays.toString(numbers));

        boolean increaseArrays = true;
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] <= numbers[i - 1]) {
                increaseArrays = false;
                break;
            }
        }
        if (increaseArrays) {
            System.out.println("Массив с возростающей последовательностью");
        } else {
            System.out.println("Массив без возростающей последовательности");
        }
    }

    private static void test4() {
        Random random = new Random();
        int[] numbers1 = new int[5];
        int[] numbers2 = new int[5];
        for (int i = 0; i < numbers1.length; i++) {
            numbers1[i] = random.nextInt(0, 5);
        }
        for (int i = 0; i < numbers2.length; i++) {
            numbers2[i] = random.nextInt(0, 5);
        }
        System.out.println(Arrays.toString(numbers1));
        System.out.println(Arrays.toString(numbers2));
        double average1 = Arrays.stream(numbers1).average().getAsDouble();
        double average2 = Arrays.stream(numbers2).average().getAsDouble();
        if (average1 > average2) {
            System.out.println("Среднее арифметическое первого массива " + average1 + " больше второго " + average2);
        } else if (average1 < average2) {
            System.out.println("Среднее арифметическое первого массива " + average1 + " меньше второго " + average2);
        } else {
            System.out.println("Среднее арифметическое массивов равно");
        }
    }

    private static void bubbleSort() {
        final Random random = new Random();
        final int[] numbers = new int[10];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = random.nextInt(100);
        }
        System.out.println(Arrays.toString(numbers));
        boolean sorted = false;
        while (!sorted) {
            sorted = true;
            for (int i = 0; i < numbers.length - 1; i++) {
                int firstNumber = numbers[i];
                int secondNumber = numbers[i + 1];
                if (firstNumber > secondNumber) {
                    int temp = firstNumber;
                    firstNumber = secondNumber;
                    secondNumber = temp;
                    sorted = false;
                }
                numbers[i] = firstNumber;
                numbers[i + 1] = secondNumber;
            }
        }
        System.out.println(Arrays.toString(numbers));
    }
}