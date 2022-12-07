package com.prodius.util;

import com.prodius.model.Type;

import java.util.Random;

public class RandomGenerator {
    private static final Random random = new Random();
    public static int getRandomNumber(){
        return random.nextInt(11);
    }
    public static Type getRandomType() {
        Type[] types = Type.values();
        int randomType = random.nextInt(types.length);
        return types[randomType];
    }
}
