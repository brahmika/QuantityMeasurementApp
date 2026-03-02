package com.bridgeLabz;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class QuantityLengthAdditionTest {

    private static final double EPSILON = 1e-6;
    // SAME UNIT ADDITION

    @Test
    void testAddition_SameUnit_FeetPlusFeet() {
        QuantityLength a = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength b = new QuantityLength(2.0, LengthUnit.FEET);

        QuantityLength result = a.add(b);

        assertEquals(new QuantityLength(3.0, LengthUnit.FEET), result);
    }

    @Test
    void testAddition_SameUnit_InchesPlusInches() {
        QuantityLength a = new QuantityLength(6.0, LengthUnit.INCHES);
        QuantityLength b = new QuantityLength(6.0, LengthUnit.INCHES);

        QuantityLength result = a.add(b);

        assertEquals(new QuantityLength(12.0, LengthUnit.INCHES), result);
    }

    // CROSS UNIT ADDITION
    @Test
    void testAddition_FeetPlusInches() {
        QuantityLength a = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength b = new QuantityLength(12.0, LengthUnit.INCHES);

        QuantityLength result = a.add(b);

        assertEquals(new QuantityLength(2.0, LengthUnit.FEET), result);
    }

    @Test
    void testAddition_InchesPlusFeet() {
        QuantityLength a = new QuantityLength(12.0, LengthUnit.INCHES);
        QuantityLength b = new QuantityLength(1.0, LengthUnit.FEET);

        QuantityLength result = a.add(b);

        assertEquals(new QuantityLength(24.0, LengthUnit.INCHES), result);
    }

    @Test
    void testAddition_YardPlusFeet() {
        QuantityLength a = new QuantityLength(1.0, LengthUnit.YARDS);
        QuantityLength b = new QuantityLength(3.0, LengthUnit.FEET);

        QuantityLength result = a.add(b);

        assertEquals(new QuantityLength(2.0, LengthUnit.YARDS), result);
    }

    @Test
    void testAddition_CentimeterPlusInch() {
        QuantityLength a = new QuantityLength(2.54, LengthUnit.CENTIMETERS);
        QuantityLength b = new QuantityLength(1.0, LengthUnit.INCHES);

        QuantityLength result = a.add(b);

        assertEquals(5.08, result.getValue(), EPSILON);
        assertEquals(LengthUnit.CENTIMETERS, result.getUnit());
    }
    // COMMUTATIVITY

    @Test
    void testAddition_CommutativeProperty() {
        QuantityLength a = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength b = new QuantityLength(12.0, LengthUnit.INCHES);

        QuantityLength result1 = a.add(b);
        QuantityLength result2 = b.add(a);

        // Convert both to base for comparison
        assertEquals(result1.convertTo(LengthUnit.FEET),
                result2.convertTo(LengthUnit.FEET));
    }
    // IDENTITY (ZERO)

    @Test
    void testAddition_WithZero() {
        QuantityLength a = new QuantityLength(5.0, LengthUnit.FEET);
        QuantityLength zero = new QuantityLength(0.0, LengthUnit.INCHES);

        QuantityLength result = a.add(zero);

        assertEquals(new QuantityLength(5.0, LengthUnit.FEET), result);
    }

    // NEGATIVE VALUES

    @Test
    void testAddition_NegativeValues() {
        QuantityLength a = new QuantityLength(5.0, LengthUnit.FEET);
        QuantityLength b = new QuantityLength(-2.0, LengthUnit.FEET);

        QuantityLength result = a.add(b);

        assertEquals(new QuantityLength(3.0, LengthUnit.FEET), result);
    }

    // ------------------------------------------------
    // LARGE & SMALL VALUES
    // ------------------------------------------------

    @Test
    void testAddition_LargeValues() {
        QuantityLength a = new QuantityLength(1e6, LengthUnit.FEET);
        QuantityLength b = new QuantityLength(1e6, LengthUnit.FEET);

        QuantityLength result = a.add(b);

        assertEquals(new QuantityLength(2e6, LengthUnit.FEET), result);
    }

    @Test
    void testAddition_SmallValues() {
        QuantityLength a = new QuantityLength(0.001, LengthUnit.FEET);
        QuantityLength b = new QuantityLength(0.002, LengthUnit.FEET);

        QuantityLength result = a.add(b);

        assertEquals(0.003, result.getValue(), EPSILON);
    }

    // NULL HANDLING

    @Test
    void testAddition_NullOperand_Throws() {
        QuantityLength a = new QuantityLength(1.0, LengthUnit.FEET);

        assertThrows(IllegalArgumentException.class, () -> a.add(null));
    }

    // IMMUTABILITY CHECK

    @Test
    void testAddition_DoesNotModifyOriginalObjects() {
        QuantityLength a = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength b = new QuantityLength(12.0, LengthUnit.INCHES);

        QuantityLength result = a.add(b);

        assertEquals(1.0, a.getValue(), EPSILON);
        assertEquals(12.0, b.getValue(), EPSILON);
        assertNotSame(a, result);
    }
}