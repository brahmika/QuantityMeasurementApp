package com.bridgeLabz.entity;
public class QuantityMeasurementEntity {

    private String operation;
    private String result;
    private boolean isError;
    private String errorMessage;

    public QuantityMeasurementEntity(String operation, String result) {
        this.operation = operation;
        this.result = result;
        this.isError = false;
    }

    public QuantityMeasurementEntity(String errorMessage) {
        this.isError = true;
        this.errorMessage = errorMessage;
    }

    public boolean isError() {
        return isError;
    }

    @Override
    public String toString() {
        if (isError) return "Error: " + errorMessage;
        return operation + " → " + result;
    }
}