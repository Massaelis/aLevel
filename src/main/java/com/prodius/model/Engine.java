package com.prodius.model;

import java.util.Random;

public class Engine {
    private TypeEngine type;
    private int power;
    private String engine;
    Random random = new Random();
    public Engine(TypeEngine type, int power){
        this.type = type;
        this.power = power;
    }
    public Engine(String type){
        this.engine = type;
        this.power = random.nextInt(1001);
    }
    //it didn't work for me to use the old method and I created it on a new one for this hw18
    public String toString(){
        return String.format("Type %s power %d", engine, power);
    }

    public TypeEngine getType(){
        return type;
    }
    public void setType(TypeEngine type){
        this.type = type;
    }

    public int getPower(){
        return power;
    }
    public void setPower(int power){
        this.power = power;
    }

/*
    public String toString(){
        return String.format("Type %s power %d", type, power);
    }

 */
    public enum TypeEngine{
        PETROL,
        DIESEL,
        HYBRID,
        GAS;
    }
}
