package com.bridgeLabz;

public interface IMeasurable {

    double toBase(double value);
    double fromBase(double value);

    // Lambda: by default all units support arithmetic
    SupportsArithmetic supportsArithmetic = () -> true;

    default boolean supportsArithmetic() {
        return supportsArithmetic.isSupported();
    }

    // default validation method
    default void validateOperationSupport(String operation) {
        // do nothing (other units allow operations)
    }
}