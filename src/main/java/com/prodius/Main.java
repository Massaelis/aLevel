package com.prodius;

public class Main {
    public static void main(String[] args) {
        String name = "Prodius Oleh";
        System.out.println(name);

        System.out.println();

        int i = 0;
        int y = 5;
        do {
            System.out.println("Крок " + i + ", значення " + y);
            i++;
            y += 2;
        } while (i <= 10);

        System.out.println();

        for (i = 0; i <= 10; i++) {
            if (i == 3)
                continue;
            if (i == 6)
                break;
            System.out.println("Крок " + i);
        }
    }
}

