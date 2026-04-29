package com.bridgeLabz.service;

import com.bridgeLabz.dto.QuantityDTO;
import com.bridgeLabz.entity.QuantityMeasurementEntity;
import com.bridgeLabz.exception.QuantityMeasurementException;
import com.bridgeLabz.repository.IQuantityMeasurementRepository;

public class QuantityMeasurementServiceImpl implements IQuantityMeasurementService {

    private IQuantityMeasurementRepository repository;

    public QuantityMeasurementServiceImpl(IQuantityMeasurementRepository repository) {
        this.repository = repository;
    }

    @Override
    public QuantityMeasurementEntity compare(QuantityDTO q1, QuantityDTO q2) {
        try {
            boolean result = q1.getValue() == q2.getValue();
            QuantityMeasurementEntity entity =
                    new QuantityMeasurementEntity("Compare", String.valueOf(result));
            repository.save(entity);
            return entity;
        } catch (Exception e) {
            return new QuantityMeasurementEntity(e.getMessage());
        }
    }

    @Override
    public QuantityMeasurementEntity add(QuantityDTO q1, QuantityDTO q2) {
        try {
            double sum = q1.getValue() + q2.getValue();
            QuantityMeasurementEntity entity =
                    new QuantityMeasurementEntity("Add", String.valueOf(sum));
            repository.save(entity);
            return entity;
        } catch (Exception e) {
            return new QuantityMeasurementEntity(e.getMessage());
        }
    }
}
