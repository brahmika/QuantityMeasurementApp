package com.bridgeLabz;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.*;

class QuantityMeasurementAppTest {


    // Tests equality when values are same
    @Test
    void testFeetEquality_SameValue() {
        assertTrue(QuantityMeasurementApp.checkFeetEquality(5.0, 5.0));
    }

    // Tests inequality when values differ
    @Test
    void testFeetEquality_DifferentValue() {
        assertFalse(QuantityMeasurementApp.checkFeetEquality(5.0, 6.0));
    }

    // Tests reflexive property (same reference)
    @Test
    void testFeetEquality_SameReference() {
        QuantityMeasurementApp.Feet feet =
                new QuantityMeasurementApp.Feet(2.0);

        assertTrue(feet.equals(feet));
    }

    // Tests null comparison safety
    @Test
    void testFeetEquality_NullComparison() {
        QuantityMeasurementApp.Feet feet =
                new QuantityMeasurementApp.Feet(2.0);

        assertFalse(feet.equals(null));
    }

    // Tests invalid numeric input
    @Test
    void testFeetEquality_NonNumericInput() {
        assertThrows(IllegalArgumentException.class,
                () -> new QuantityMeasurementApp.Feet(Double.NaN));
    }

    @Test
    void testInchesEquality_SameValue() {
        assertTrue(QuantityMeasurementApp.checkInchesEquality(3.0, 3.0));
    }

    @Test
    void testInchesEquality_DifferentValue() {
        assertFalse(QuantityMeasurementApp.checkInchesEquality(3.0, 4.0));
    }

    @Test
    void testInchesEquality_SameReference() {
        QuantityMeasurementApp.Inches inch =
                new QuantityMeasurementApp.Inches(1.0);

        assertTrue(inch.equals(inch));
    }

    @Test
    void testInchesEquality_NullComparison() {
        QuantityMeasurementApp.Inches inch =
                new QuantityMeasurementApp.Inches(1.0);

        assertFalse(inch.equals(null));
    }

    @Test
    void testInchesEquality_NonNumericInput() {
        assertThrows(IllegalArgumentException.class,
                () -> new QuantityMeasurementApp.Inches(Double.POSITIVE_INFINITY));
    }
}