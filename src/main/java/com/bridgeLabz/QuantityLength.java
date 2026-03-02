package com.bridgeLabz;
import java.util.Objects;
public final class QuantityLength {

    private final double value;
    private final LengthUnit unit;

    private static final double EPSILON = 1e-6;

    public QuantityLength(double value, LengthUnit unit) {

        if (!Double.isFinite(value)) {
            throw new IllegalArgumentException("Value must be finite.");
        }

        if (unit == null) {
            throw new IllegalArgumentException("Unit cannot be null.");
        }

        this.value = value;
        this.unit = unit;
    }

    // -----------------------------
    // Getter
    // -----------------------------

    public double getValue() {
        return value;
    }

    public LengthUnit getUnit() {
        return unit;
    }

    public QuantityLength convertTo(LengthUnit targetUnit) {

        if (targetUnit == null) {
            throw new IllegalArgumentException("Target unit cannot be null.");
        }

        double baseValue = unit.toBase(value);
        double converted = targetUnit.fromBase(baseValue);

        return new QuantityLength(converted, targetUnit);
    }

    public static double convert(double value,
                                 LengthUnit source,
                                 LengthUnit target) {

        if (!Double.isFinite(value)) {
            throw new IllegalArgumentException("Value must be finite.");
        }

        if (source == null || target == null) {
            throw new IllegalArgumentException("Units cannot be null.");
        }

        double base = source.toBase(value);
        return target.fromBase(base);
    }

    // Addition (UC6)

    /**
     * Adds another QuantityLength to this one.
     * Result is returned in the unit of this object.
     */
    public QuantityLength add(QuantityLength other) {

        if (other == null) {
            throw new IllegalArgumentException("Other quantity cannot be null.");
        }

        double baseThis = this.toBase();
        double baseOther = other.toBase();

        double baseSum = baseThis + baseOther;

        double resultValue = this.unit.fromBase(baseSum);

        return new QuantityLength(resultValue, this.unit);
    }
    // Base normalization
    private double toBase() {
        return unit.toBase(value);
    }
    // Equality

    @Override
    public boolean equals(Object obj) {

        if (this == obj) return true;

        if (!(obj instanceof QuantityLength other)) return false;

        return Math.abs(this.toBase() - other.toBase()) < EPSILON;
    }

    @Override
    public int hashCode() {
        return Objects.hash(Math.round(toBase() / EPSILON));
    }

    @Override
    public String toString() {
        return "Quantity(" + value + ", " + unit + ")";
    }
}