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

        QuantityLength q1 =
                new QuantityLength(1.0, LengthUnit.FEET);

        QuantityLength q2 =
                new QuantityLength(12.0, LengthUnit.INCH);

        System.out.println(q1 + " and " + q2 +
                " → Equal: " + q1.equals(q2));

        QuantityLength q3 =
                new QuantityLength(1.0, LengthUnit.INCH);

        QuantityLength q4 =
                new QuantityLength(1.0, LengthUnit.INCH);

        System.out.println(q3 + " and " + q4 +
                " → Equal: " + q3.equals(q4));
    }
}