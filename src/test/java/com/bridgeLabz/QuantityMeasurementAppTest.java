package com.bridgeLabz;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class QuantityLengthTest {

    private static final double EPSILON = 1e-6;

    // BASIC CONVERSIONS

    @Test
    void testConversion_FeetToInches() {
        double result = QuantityLength.convert(1.0, LengthUnit.FEET, LengthUnit.INCHES);
        assertEquals(12.0, result, EPSILON);
    }

    @Test
    void testConversion_InchesToFeet() {
        double result = QuantityLength.convert(24.0, LengthUnit.INCHES, LengthUnit.FEET);
        assertEquals(2.0, result, EPSILON);
    }

    @Test
    void testConversion_YardsToFeet() {
        double result = QuantityLength.convert(3.0, LengthUnit.YARDS, LengthUnit.FEET);
        assertEquals(9.0, result, EPSILON);
    }

    @Test
    void testConversion_YardsToInches() {
        double result = QuantityLength.convert(1.0, LengthUnit.YARDS, LengthUnit.INCHES);
        assertEquals(36.0, result, EPSILON);
    }

    @Test
    void testConversion_CentimetersToInches() {
        double result = QuantityLength.convert(2.54, LengthUnit.CENTIMETERS, LengthUnit.INCHES);
        assertEquals(1.0, result, EPSILON);
    }

    // SAME UNIT CONVERSION

    @Test
    void testConversion_SameUnit() {
        double result = QuantityLength.convert(5.0, LengthUnit.FEET, LengthUnit.FEET);
        assertEquals(5.0, result, EPSILON);
    }

    // ZERO & NEGATIVE VALUES


    @Test
    void testConversion_ZeroValue() {
        double result = QuantityLength.convert(0.0, LengthUnit.FEET, LengthUnit.INCHES);
        assertEquals(0.0, result, EPSILON);
    }

    @Test
    void testConversion_NegativeValue() {
        double result = QuantityLength.convert(-1.0, LengthUnit.FEET, LengthUnit.INCHES);
        assertEquals(-12.0, result, EPSILON);
    }

    // ROUND TRIP ACCURACY

    @Test
    void testConversion_RoundTrip() {
        double original = 5.0;

        double toInches = QuantityLength.convert(original, LengthUnit.FEET, LengthUnit.INCHES);
        double backToFeet = QuantityLength.convert(toInches, LengthUnit.INCHES, LengthUnit.FEET);

        assertEquals(original, backToFeet, EPSILON);
    }

    // EQUALITY TESTS

    @Test
    void testEquality_YardToFeet() {
        QuantityLength yard = new QuantityLength(1.0, LengthUnit.YARDS);
        QuantityLength feet = new QuantityLength(3.0, LengthUnit.FEET);

        assertEquals(yard, feet);
    }

    @Test
    void testEquality_CentimeterToInches() {
        QuantityLength cm = new QuantityLength(2.54, LengthUnit.CENTIMETERS);
        QuantityLength inch = new QuantityLength(1.0, LengthUnit.INCHES);

        assertEquals(cm, inch);
    }

    @Test
    void testEquality_SameReference() {
        QuantityLength length = new QuantityLength(2.0, LengthUnit.FEET);
        assertEquals(length, length);
    }

    @Test
    void testEquality_NullComparison() {
        QuantityLength length = new QuantityLength(2.0, LengthUnit.FEET);
        assertNotEquals(length, null);
    }

    // INVALID INPUT TESTS

    @Test
    void testConversion_NullSourceUnit_Throws() {
        assertThrows(IllegalArgumentException.class, () ->
                QuantityLength.convert(1.0, null, LengthUnit.FEET));
    }

    @Test
    void testConversion_NullTargetUnit_Throws() {
        assertThrows(IllegalArgumentException.class, () ->
                QuantityLength.convert(1.0, LengthUnit.FEET, null));
    }

    @Test
    void testConversion_NaNValue_Throws() {
        assertThrows(IllegalArgumentException.class, () ->
                QuantityLength.convert(Double.NaN, LengthUnit.FEET, LengthUnit.INCHES));
    }

    @Test
    void testConversion_InfiniteValue_Throws() {
        assertThrows(IllegalArgumentException.class, () ->
                QuantityLength.convert(Double.POSITIVE_INFINITY, LengthUnit.FEET, LengthUnit.INCHES));
    }

    // TRANSITIVE PROPERTY

    @Test
    void testEquality_TransitiveProperty() {

        QuantityLength yard = new QuantityLength(1.0, LengthUnit.YARDS);
        QuantityLength feet = new QuantityLength(3.0, LengthUnit.FEET);
        QuantityLength inches = new QuantityLength(36.0, LengthUnit.INCHES);

        assertEquals(yard, feet);
        assertEquals(feet, inches);
        assertEquals(yard, inches);
    }
}