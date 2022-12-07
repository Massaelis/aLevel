package com.prodius.util;

import java.util.Random;

public class RandomGenerator {
    private static final Random random = new Random();
    public static int getRandomNumber(){
        return random.nextInt(11);
    }
}
