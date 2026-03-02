/**
 * LengthUnit Enum
 *
 * Represents supported length units.
 * Each unit stores its conversion factor relative to
 * the base unit (FEET).
 */
package com.bridgeLabz;

public enum LengthUnit {

    FEET(1.0),
    INCHES(1.0 / 12.0),
    YARDS(3.0),
    CENTIMETERS(0.0328084); // 1 cm = 0.0328084 feet

    private final double toFeetFactor;

    LengthUnit(double toFeetFactor) {
        this.toFeetFactor = toFeetFactor;
    }

    /**
     * Converts value to base unit (FEET)
     */
    public double toBase(double value) {
        return value * toFeetFactor;
    }

    /**
     * Converts from base unit (FEET) to this unit
     */
    public double fromBase(double baseValue) {
        return baseValue / toFeetFactor;
    }

    public double getConversionFactor() {
        return toFeetFactor;
    }
}
