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

    INCH(1.0 / 12.0),

    YARDS(3.0),

    CENTIMETERS(0.0328084167);  // 1 cm in feet

    private final double toBaseFactor;

    LengthUnit(double toBaseFactor) {
        this.toBaseFactor = toBaseFactor;
    }

    /**
     * Converts value to FEET (base unit)
     */
    public double toBase(double value) {
        return value * toBaseFactor;
    }
}