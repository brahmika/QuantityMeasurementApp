package com.bridgeLabz;

public class QuantityMeasurementApp {

    public static void main(String[] args) {

        Quantity<LengthUnit> q1 =
                new Quantity<>(10.0, LengthUnit.FOOT);

        Quantity<LengthUnit> q2 =
                new Quantity<>(6.0, LengthUnit.INCH);

        Quantity<LengthUnit> addResult = q1.add(q2);

        Quantity<LengthUnit> subtractResult = q1.subtract(q2);

        double divideResult =
                q1.divide(new Quantity<>(2.0, LengthUnit.FOOT));

        System.out.println("Addition: " + addResult);
        System.out.println("Subtraction: " + subtractResult);
        System.out.println("Division: " + divideResult);
    }
}