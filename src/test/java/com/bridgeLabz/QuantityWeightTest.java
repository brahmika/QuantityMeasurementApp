package com.bridgeLabz;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuantityWeightTest {

    @Test
    void testEquality_KilogramToKilogram() {
        assertEquals(
                new QuantityWeight(1.0, WeightUnit.KILOGRAM),
                new QuantityWeight(1.0, WeightUnit.KILOGRAM)
        );
    }

    @Test
    void testEquality_KilogramToGram() {
        assertEquals(
                new QuantityWeight(1.0, WeightUnit.KILOGRAM),
                new QuantityWeight(1000.0, WeightUnit.GRAM)
        );
    }

    @Test
    void testEquality_KilogramToPound() {
        assertEquals(
                new QuantityWeight(1.0, WeightUnit.KILOGRAM),
                new QuantityWeight(2.20462, WeightUnit.POUND)
        );
    }

    @Test
    void testConversion_PoundToKilogram() {
        QuantityWeight result =
                new QuantityWeight(2.20462, WeightUnit.POUND)
                        .convertTo(WeightUnit.KILOGRAM);

        assertEquals(
                new QuantityWeight(1.0, WeightUnit.KILOGRAM),
                result
        );
    }

    @Test
    void testAddition_SameUnit() {
        QuantityWeight result =
                new QuantityWeight(1.0, WeightUnit.KILOGRAM)
                        .add(new QuantityWeight(2.0, WeightUnit.KILOGRAM));

        assertEquals(
                new QuantityWeight(3.0, WeightUnit.KILOGRAM),
                result
        );
    }

    @Test
    void testAddition_CrossUnit() {
        QuantityWeight result =
                new QuantityWeight(1.0, WeightUnit.KILOGRAM)
                        .add(new QuantityWeight(1000.0, WeightUnit.GRAM));

        assertEquals(
                new QuantityWeight(2.0, WeightUnit.KILOGRAM),
                result
        );
    }

    @Test
    void testAddition_ExplicitTargetUnit() {
        QuantityWeight result =
                new QuantityWeight(1.0, WeightUnit.KILOGRAM)
                        .add(new QuantityWeight(1000.0, WeightUnit.GRAM),
                                WeightUnit.GRAM);

        assertEquals(
                new QuantityWeight(2000.0, WeightUnit.GRAM),
                result
        );
    }

    @Test
    void testZeroValue() {
        assertEquals(
                new QuantityWeight(0.0, WeightUnit.KILOGRAM),
                new QuantityWeight(0.0, WeightUnit.GRAM)
        );
    }

    @Test
    void testNegativeWeight() {
        assertEquals(
                new QuantityWeight(-1.0, WeightUnit.KILOGRAM),
                new QuantityWeight(-1000.0, WeightUnit.GRAM)
        );
    }

    @Test
    void testNullComparison() {
        assertNotEquals(
                new QuantityWeight(1.0, WeightUnit.KILOGRAM),
                null
        );
    }
}