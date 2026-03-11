package com.bridgeLabz;

public class Quantity<U extends Enum<U> & IMeasurable> {

    private final double value;
    private final U unit;

    public Quantity(double value, U unit) {
        if (unit == null) {
            throw new IllegalArgumentException("Unit cannot be null");
        }
        this.value = value;
        this.unit = unit;
    }

    public double toBase() {
        return unit.toBase(value);
    }

    public Quantity<U> add(Quantity<U> other) {

        unit.validateOperationSupport("addition");

        double result = this.toBase() + other.toBase();
        return new Quantity<>(unit.fromBase(result), unit);
    }

    public Quantity<U> subtract(Quantity<U> other) {

        unit.validateOperationSupport("subtraction");

        double result = this.toBase() - other.toBase();
        return new Quantity<>(unit.fromBase(result), unit);
    }

    public double divide(Quantity<U> other) {

        unit.validateOperationSupport("division");

        return this.toBase() / other.toBase();
    }

    public Quantity<U> convertTo(U newUnit) {

        double baseValue = unit.toBase(value);
        double converted = newUnit.fromBase(baseValue);

        return new Quantity<>(converted, newUnit);
    }

    @Override
    public boolean equals(Object obj) {

        if (!(obj instanceof Quantity<?> other)) return false;

        if (!unit.getClass().equals(other.unit.getClass()))
            return false;

        double thisBase = this.toBase();
        double otherBase = ((Quantity<?>) obj).toBase();

        return Math.abs(thisBase - otherBase) < 0.01;
    }

    @Override
    public String toString() {
        return value + " " + unit;
    }
}