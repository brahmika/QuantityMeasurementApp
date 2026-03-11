package com.bridgeLabz;

public enum VolumeUnit implements IMeasurable {

    MILLILITER(1.0),
    LITER(1000.0);

    private final double toBaseFactor;

    VolumeUnit(double toBaseFactor) {
        this.toBaseFactor = toBaseFactor;
    }

    @Override
    public double convertToBaseUnit(double value) {
        return value * toBaseFactor;
    }

    @Override
    public double convertFromBaseUnit(double baseValue) {
        return baseValue / toBaseFactor;
    }
}