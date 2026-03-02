/**
 * QuantityMeasurementApp
 *
 * This class demonstrates UC2:
 * Equality comparison for Feet and Inches measurements.
 *
 * Note:
 * - Feet is only compared with Feet
 * - Inches is only compared with Inches
 * - No cross-unit comparison is performed
 */
package com.bridgeLabz;

import java.util.Objects;

/**
 * Demonstrates UC3 functionality.
 */
public class QuantityMeasurementApp {

    public static void main(String[] args) {

        QuantityLength a = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength b = new QuantityLength(12.0, LengthUnit.INCHES);

        System.out.println("Addition Example:");
        System.out.println(a + " + " + b + " = " + a.add(b));

        QuantityLength yard = new QuantityLength(1.0, LengthUnit.YARDS);
        QuantityLength feet = new QuantityLength(3.0, LengthUnit.FEET);

        System.out.println(yard + " + " + feet + " = " + yard.add(feet));

        QuantityLength cm = new QuantityLength(2.54, LengthUnit.CENTIMETERS);
        QuantityLength inch = new QuantityLength(1.0, LengthUnit.INCHES);

        System.out.println(cm + " + " + inch + " = " + cm.add(inch));
    }
}