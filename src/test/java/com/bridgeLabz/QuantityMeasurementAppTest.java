package com.bridgeLabz;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class QuantityLengthTest {

    private static final double EPSILON = 0.001;

    @Test
    void testAddition_ExplicitTargetUnit_Feet() {
        QuantityLength result =
                new QuantityLength(1.0, LengthUnit.FEET)
                        .add(new QuantityLength(12.0, LengthUnit.INCHES),
                                LengthUnit.FEET);

        assertEquals(2.0, result.getValue(), EPSILON);
        assertEquals(LengthUnit.FEET, result.getUnit());
    }

    @Test
    void testAddition_ExplicitTargetUnit_Inches() {
        QuantityLength result =
                new QuantityLength(1.0, LengthUnit.FEET)
                        .add(new QuantityLength(12.0, LengthUnit.INCHES),
                                LengthUnit.INCHES);

        assertEquals(24.0, result.getValue(), EPSILON);
        assertEquals(LengthUnit.INCHES, result.getUnit());
    }

    @Test
    void testAddition_ExplicitTargetUnit_Yards() {
        QuantityLength result =
                new QuantityLength(1.0, LengthUnit.FEET)
                        .add(new QuantityLength(12.0, LengthUnit.INCHES),
                                LengthUnit.YARDS);

        assertEquals(0.667, result.getValue(), EPSILON);
        assertEquals(LengthUnit.YARDS, result.getUnit());
    }

    @Test
    void testAddition_Commutativity_WithTargetUnit() {
        QuantityLength a =
                new QuantityLength(1.0, LengthUnit.FEET);

        QuantityLength b =
                new QuantityLength(12.0, LengthUnit.INCHES);

        QuantityLength result1 = a.add(b, LengthUnit.YARDS);
        QuantityLength result2 = b.add(a, LengthUnit.YARDS);

        assertEquals(result1.getValue(), result2.getValue(), EPSILON);
        assertEquals(result1.getUnit(), result2.getUnit());
    }

    @Test
    void testAddition_WithZero() {
        QuantityLength result =
                new QuantityLength(5.0, LengthUnit.FEET)
                        .add(new QuantityLength(0.0, LengthUnit.INCHES),
                                LengthUnit.YARDS);

        assertEquals(1.667, result.getValue(), EPSILON);
    }

    @Test
    void testAddition_NegativeValues() {
        QuantityLength result =
                new QuantityLength(5.0, LengthUnit.FEET)
                        .add(new QuantityLength(-2.0, LengthUnit.FEET),
                                LengthUnit.INCHES);

        assertEquals(36.0, result.getValue(), EPSILON);
    }

    @Test
    void testAddition_NullTargetUnit() {
        assertThrows(IllegalArgumentException.class, () ->
                new QuantityLength(1.0, LengthUnit.FEET)
                        .add(new QuantityLength(12.0, LengthUnit.INCHES),
                                null));
    }

    @Test
    void testAddition_LargeToSmallScale() {
        QuantityLength result =
                new QuantityLength(1000.0, LengthUnit.FEET)
                        .add(new QuantityLength(500.0, LengthUnit.FEET),
                                LengthUnit.INCHES);

        assertEquals(18000.0, result.getValue(), EPSILON);
    }

    @Test
    void testAddition_SmallToLargeScale() {
        QuantityLength result =
                new QuantityLength(12.0, LengthUnit.INCHES)
                        .add(new QuantityLength(12.0, LengthUnit.INCHES),
                                LengthUnit.YARDS);

        assertEquals(0.667, result.getValue(), EPSILON);
    }
}