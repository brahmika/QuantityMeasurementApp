package com.bridgeLabz;

public enum WeightUnit implements IMeasurable {

    GRAM(1.0),
    KILOGRAM(1000.0);

    private final double conversionFactor;

    WeightUnit(double factor) {
        this.conversionFactor = factor;
    }

    public double getConversionFactor() {
        return conversionFactor;
    }

    public String getUnitName() {
        return this.name();
    }
}