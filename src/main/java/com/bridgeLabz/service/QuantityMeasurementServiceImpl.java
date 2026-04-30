package com.bridgeLabz.service;

import com.bridgeLabz.dto.QuantityDTO;
import com.bridgeLabz.entity.QuantityMeasurementEntity;
import com.bridgeLabz.repository.IQuantityMeasurementRepository;

import com.bridgeLabz.repository.QuantityMeasurementRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuantityMeasurementServiceImpl {

    private final QuantityMeasurementRepository repository;

    public QuantityMeasurementServiceImpl(QuantityMeasurementRepository repository) {
        this.repository = repository;
    }

    public QuantityMeasurementEntity save(QuantityMeasurementEntity entity) {
        return repository.save(entity);
    }

    public List<QuantityMeasurementEntity> getAll() {
        return repository.findAll();
    }

    public List<QuantityMeasurementEntity> getByOperation(String op) {
        return repository.findByOperation(op);
    }
}