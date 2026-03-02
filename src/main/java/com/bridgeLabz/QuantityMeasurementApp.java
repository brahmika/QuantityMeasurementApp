/**
 * QuantityMeasurementApp - UC1: Feet measurement equality
 *
 *
 * This class is responsible for checking the equality of two numerical values measured in feet in the Quantity Measurement Application.
 *
 * **/
package com.bridgeLabz;

import java.util.Objects;

public class QuantityMeasurementApp {
    //Inner class to represent Feet measurement
    public static class Feet {
        private final double value;
        public Feet(double value) {
            this.value = value;
        }

        @Override
        public boolean equals(Object obj) {
            if(this == obj)
                return true;
            if (obj == null || getClass() != obj.getClass())
                return false;
            Feet other = (Feet) obj;

            return Double.compare(this.value, other.value) == 0;
        }

        public  int hasCode() {
            return Objects.hash(value);
        }

        @Override
        public String toString() {
            return value + " ft";
        }
    }
    public static void main(String[] args){
        Feet feet1 = new Feet(5.0);
        Feet feet2 = new Feet(5.0);

        boolean isEqual = feet1.equals(feet2);
        System.out.println("Are the two feet measurements equal? " + isEqual);
    }
}
