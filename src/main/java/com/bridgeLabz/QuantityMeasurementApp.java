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

public class QuantityMeasurementApp {

    /**
       Feet Class
       Represents a measurement in Feet.
       Encapsulates value and overrides equals() method
       for value-based comparison.
      **/
    public static class Feet {

        // Immutable value of measurement
        private final double value;

        /**
         * Constructor to initialize Feet value.
         */
        public Feet(double value) {
            validate(value);
            this.value = value;
        }

        /**
         * Validates that the value is neither NaN nor Infinite.
         */
        private void validate(double value) {
            if (Double.isNaN(value) || Double.isInfinite(value)) {
                throw new IllegalArgumentException("Invalid Feet value");
            }
        }

        @Override
        public boolean equals(Object obj) {

            // Check same reference
            if (this == obj) return true;

            // Check null and type
            if (obj == null || getClass() != obj.getClass()) return false;

            // Cast object
            Feet other = (Feet) obj;

            // Compare double values safely
            return Double.compare(this.value, other.value) == 0;
        }

        /**
         * hashCode must be overridden
         * whenever equals() is overridden.
         */
        @Override
        public int hashCode() {
            return Objects.hash(value);
        }
    }

    /*
       INCHES CLASS
       Represents a measurement in Inches.
       Similar to Feet class but treated independently.
     */
    public static class Inches {

        // Immutable measurement value
        private final double value;

        /**
         * Constructor to initialize Inches value.
         */
        public Inches(double value) {
            validate(value);
            this.value = value;
        }

        /**
         * Validates numeric correctness.
         */
        private void validate(double value) {
            if (Double.isNaN(value) || Double.isInfinite(value)) {
                throw new IllegalArgumentException("Invalid Inches value");
            }
        }

        /**
         * Overrides equals() for value-based comparison.
         */
        @Override
        public boolean equals(Object obj) {

            // Same reference check
            if (this == obj) return true;

            // Null and type check
            if (obj == null || getClass() != obj.getClass()) return false;

            Inches other = (Inches) obj;

            // Floating-point safe comparison
            return Double.compare(this.value, other.value) == 0;
        }

        /**
         * Overridden to maintain equals-hashCode contract.
         */
        @Override
        public int hashCode() {
            return Objects.hash(value);
        }
    }

    /*
       STATIC METHODS
       These reduce dependency on main()
       and encapsulate equality logic.
    */

    /**
     * Compares two Feet values for equality.
     * Instantiates Feet objects internally.
     */
    public static boolean checkFeetEquality(double value1, double value2) {
        Feet feet1 = new Feet(value1);
        Feet feet2 = new Feet(value2);
        return feet1.equals(feet2);
    }

    /**
     * Compares two Inches values for equality.
     */
    public static boolean checkInchesEquality(double value1, double value2) {
        Inches inch1 = new Inches(value1);
        Inches inch2 = new Inches(value2);
        return inch1.equals(inch2);
    }
    //Main method
    public static void main(String[] args) {

        System.out.println("1.0 ft and 1.0 ft → "
                + checkFeetEquality(1.0, 1.0));

        System.out.println("1.0 inch and 1.0 inch → "
                + checkInchesEquality(1.0, 1.0));
    }
}