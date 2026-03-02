package com.bridgeLabz;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class QuantityMeasurementAppTest {
    @Test
    void givenTwoEqualFeetValues_shouldReturnTrue(){
        QuantityMeasurementApp.Feet feet1 = new QuantityMeasurementApp.Feet(5.0);
        QuantityMeasurementApp.Feet feet2 = new QuantityMeasurementApp.Feet(6.0);

        assertFalse(feet1.equals(feet2));
    }
    @Test
    void givenTwoDifferentFeetValues_shouldReturnFalse(){
        QuantityMeasurementApp.Feet feet1 = new QuantityMeasurementApp.Feet(5.0);
        QuantityMeasurementApp.Feet feet2 = new QuantityMeasurementApp.Feet(6.0);

        assertFalse(feet1.equals(feet2));
    }

    @Test
    void givenSameReference_shouldReturnTrue(){
        QuantityMeasurementApp.Feet feet1 = new QuantityMeasurementApp.Feet(5.0);
        assertTrue(feet1.equals(feet1));
    }

    @Test
    void givenNull_shouldReturnFalse() {
        QuantityMeasurementApp.Feet feet1 = new QuantityMeasurementApp.Feet(5.0);

        assertFalse(feet1.equals(null));
    }
    @Test
    void givenDifferentType_shouldReturnFalse() {
        QuantityMeasurementApp.Feet feet1 = new QuantityMeasurementApp.Feet(5.0);
        assertFalse(feet1.equals("5.0"));
    }
}

