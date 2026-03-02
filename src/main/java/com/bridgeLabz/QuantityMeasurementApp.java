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

        System.out.println(
                QuantityLength.convert(1.0, LengthUnit.FEET, LengthUnit.INCHES)
        );  // 12.0

        System.out.println(
                QuantityLength.convert(3.0, LengthUnit.YARDS, LengthUnit.FEET)
        );  // 9.0

        System.out.println(
                QuantityLength.convert(36.0, LengthUnit.INCHES, LengthUnit.YARDS)
        );  // 1.0

        System.out.println(
                QuantityLength.convert(1.0, LengthUnit.CENTIMETERS, LengthUnit.INCHES)
        );  // ≈ 0.393701
    }
}