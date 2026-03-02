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

        QuantityWeight w1 = new QuantityWeight(1.0, WeightUnit.KILOGRAM);
        QuantityWeight w2 = new QuantityWeight(1000.0, WeightUnit.GRAM);

        System.out.println("Equality: " + w1.equals(w2));

        QuantityWeight converted = w1.convertTo(WeightUnit.POUND);
        System.out.println("Converted: " + converted);

        QuantityWeight sum = w1.add(w2);
        System.out.println("Sum: " + sum);

        QuantityWeight explicitSum =
                w1.add(w2, WeightUnit.GRAM);
        System.out.println("Explicit Sum: " + explicitSum);
    }
}