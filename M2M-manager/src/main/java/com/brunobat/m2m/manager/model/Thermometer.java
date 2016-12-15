package com.brunobat.m2m.manager.model;


import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by Bruno Baptista on 14/12/16.
 */
public class Thermometer implements Device {

    private final String name;

    public Thermometer(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getReading() {
        return String.valueOf(ThreadLocalRandom.current().nextInt(-5, 45));
    }
}
