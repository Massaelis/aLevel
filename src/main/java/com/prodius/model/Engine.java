package com.prodius.model;

public class Engine {
    private TypeEngine type;
    private int power;
    public Engine(TypeEngine type, int power){
        this.type = type;
        this.power = power;
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

    public String toString(){
        return String.format("Type %s power %d", type, power);
    }
    public enum TypeEngine{
        PETROL,
        DIESEL,
        HYBRID,
        GAS;
    }
}
