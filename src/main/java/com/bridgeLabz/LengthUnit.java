/**
 * LengthUnit Enum
 *
 * Represents supported length units.
 * Each unit stores its conversion factor relative to
 * the base unit (FEET).
 */
package com.bridgeLabz;

public enum LengthUnit {

    FEET(1.0),                // base unit
    INCHES(1.0 / 12.0),       // 12 inches = 1 foot
    YARDS(3.0),               // 1 yard = 3 feet
    CENTIMETERS(1.0 / 30.48); // 30.48 cm = 1 foot

    private final double conversionFactor; // relative to FEET

    LengthUnit(double conversionFactor) {
        this.conversionFactor = conversionFactor;
    }

    // Convert given value to base unit (feet)
    public double toBase(double value) {
        return value * conversionFactor;
    }

    // Convert from base unit (feet) to this unit
    public double fromBase(double baseValue) {
        return baseValue / conversionFactor;
    }
}