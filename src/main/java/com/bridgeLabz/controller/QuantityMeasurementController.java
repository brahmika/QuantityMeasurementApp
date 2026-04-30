package com.bridgeLabz.controller;

import com.bridgeLabz.dto.QuantityDTO;
import com.bridgeLabz.entity.QuantityMeasurementEntity;
import com.bridgeLabz.service.IQuantityMeasurementService;

public class QuantityMeasurementController {

    private IQuantityMeasurementService service;

    public QuantityMeasurementController(IQuantityMeasurementService service) {
        this.service = service;
    }

    public void performComparison(QuantityDTO q1, QuantityDTO q2) {
        QuantityMeasurementEntity result = service.compare(q1, q2);
        System.out.println(result);
    }

    public void performAddition(QuantityDTO q1, QuantityDTO q2) {
        QuantityMeasurementEntity result = service.add(q1, q2);
        System.out.println(result);
    }
}