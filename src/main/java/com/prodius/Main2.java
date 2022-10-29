package com.prodius;

public class Main2 {
    public static void main(String[] args) {

        int a = 3 + (int) ( Math.random() * 3 ); // Генерирую числа от 3х к 5ти
        System.out.println(a);
        int b = 3 + (int) ( Math.random() * 3 );
        System.out.println(b);
        int c = 3 + (int) ( Math.random() * 3 );
        System.out.println(c);
        double p = (a + b + c) / 2.0;
        double x = Math.sqrt(p * (p - a) * (p - b) * (p - c)); // Вычисление площади по формуле Герона
        System.out.println("Площадь треугольника: " + x);

        System.out.println();

        int q = (int) ( Math.random() * -100);
        System.out.println(q);
        int w = (int) ( Math.random() * -100);
        System.out.println(w);
        int e = (int) ( Math.random() * -100);
        System.out.println(e);

        int min = Math.abs(q) < Math.abs(w) ? Math.abs(q) : Math.abs(w);
        min = Math.abs(e) < min ? Math.abs(e) : min;
        System.out.println("Меньшее по модулю число: " + min);

        System.out.println();

        int num = (int) ( Math.random() * 100 );
        if ( num % 2 == 0 )
            System.out.println(num + " Число четное");
        else
            System.out.println(num + " Число нечетное");

        System.out.println();

        int i = (int) ( Math.random() * 256+1 );
        System.out.println(i);
        String binary = Integer.toBinaryString(i);
        System.out.println("В двоичной системе: " + binary);
    }
}

