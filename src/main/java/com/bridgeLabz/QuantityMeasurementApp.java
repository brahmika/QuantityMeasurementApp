package com.bridgeLabz;

public class QuantityMeasurementApp {

    public static void main(String[] args) {

        Quantity<TemperatureUnit> temp1 =
                new Quantity<>(0, TemperatureUnit.CELSIUS);

        Quantity<TemperatureUnit> temp2 =
                new Quantity<>(32, TemperatureUnit.FAHRENHEIT);

        System.out.println("Equality Test:");
        System.out.println(temp1.equals(temp2));

        System.out.println("\nConversion Test:");
        System.out.println(
                new Quantity<>(100, TemperatureUnit.CELSIUS)
                        .convertTo(TemperatureUnit.FAHRENHEIT)
        );

        System.out.println("\nUnsupported Operation Test:");

        try {
            temp1.add(new Quantity<>(50, TemperatureUnit.CELSIUS));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}