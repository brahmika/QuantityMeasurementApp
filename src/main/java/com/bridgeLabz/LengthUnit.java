/**
 * LengthUnit Enum
 *
 * Represents supported length units.
 * Each unit stores its conversion factor relative to
 * the base unit (FEET).
 */
package com.bridgeLabz;

public enum LengthUnit implements IMeasurable {

    FEET(12.0),
    INCHES(1.0),
    YARDS(36.0),
    CENTIMETERS(0.393701);

    private final double conversionFactor;

    LengthUnit(double factor) {
        this.conversionFactor = factor;
    }

    public double getConversionFactor() {
        return conversionFactor;
    }

    public String getUnitName() {
        return this.name();
    }
}