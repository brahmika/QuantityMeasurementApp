package com.bridgeLabz;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class QuantityLengthTest {

    private static final double EPSILON = 0.001;

    // ---------- LengthUnit Tests ----------

    @Test
    void testConvertToBaseUnit_InchesToFeet() {
        assertEquals(1.0,
                LengthUnit.INCHES.convertToBaseUnit(12.0),
                EPSILON);
    }

    @Test
    void testConvertFromBaseUnit_FeetToInches() {
        assertEquals(12.0,
                LengthUnit.INCHES.convertFromBaseUnit(1.0),
                EPSILON);
    }

    @Test
    void testConvertToBaseUnit_YardsToFeet() {
        assertEquals(3.0,
                LengthUnit.YARDS.convertToBaseUnit(1.0),
                EPSILON);
    }

    // ---------- QuantityLength Tests ----------

    @Test
    void testConvertTo() {
        QuantityLength result =
                new QuantityLength(1.0, LengthUnit.FEET)
                        .convertTo(LengthUnit.INCHES);

        assertEquals(12.0, result.getValue(), EPSILON);
    }

    @Test
    void testEquality_CrossUnit() {
        assertTrue(
                new QuantityLength(1.0, LengthUnit.FEET)
                        .equals(new QuantityLength(12.0, LengthUnit.INCHES))
        );
    }

    @Test
    void testAdd_WithExplicitTargetUnit() {
        QuantityLength result =
                new QuantityLength(1.0, LengthUnit.FEET)
                        .add(new QuantityLength(12.0, LengthUnit.INCHES),
                                LengthUnit.YARDS);

        assertEquals(0.667, result.getValue(), EPSILON);
        assertEquals(LengthUnit.YARDS, result.getUnit());
    }

    @Test
    void testNullUnit() {
        assertThrows(IllegalArgumentException.class,
                () -> new QuantityLength(1.0, null));
    }

    @Test
    void testInvalidValue() {
        assertThrows(IllegalArgumentException.class,
                () -> new QuantityLength(Double.NaN, LengthUnit.FEET));
    }

    @Test
    void testRoundTripConversion() {
        QuantityLength original =
                new QuantityLength(5.0, LengthUnit.FEET);

        QuantityLength converted =
                original.convertTo(LengthUnit.INCHES)
                        .convertTo(LengthUnit.FEET);

        assertEquals(original.getValue(),
                converted.getValue(),
                EPSILON);
    }
}