/**
 * LengthUnit Enum
 *
 * Represents supported length units.
 * Each unit stores its conversion factor relative to
 * the base unit (FEET).
 */
package com.bridgeLabz;

public enum LengthUnit {

    FEET(1.0),                 // Base unit
    INCH(1.0 / 12.0),        // 12 inches = 1 foot
    YARDS(3.0),                // 1 yard = 3 feet
    CENTIMETERS(1.0 / 30.48);  // 30.48 cm = 1 foot

    private final double conversionFactorToFeet;

    LengthUnit(double conversionFactorToFeet) {
        this.conversionFactorToFeet = conversionFactorToFeet;
    }

    // Convert value in THIS unit → FEET (base unit)
    public double convertToBaseUnit(double value) {
        return value * conversionFactorToFeet;
    }

    // Convert value in FEET → THIS unit
    public double convertFromBaseUnit(double baseValue) {
        return baseValue / conversionFactorToFeet;
    }

    public double getConversionFactor() {
        return conversionFactorToFeet;
    }
}