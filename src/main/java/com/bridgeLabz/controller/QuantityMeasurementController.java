package com.bridgeLabz.controller;

import com.bridgeLabz.dto.QuantityDTO;
import com.bridgeLabz.entity.QuantityMeasurementEntity;
import com.bridgeLabz.service.IQuantityMeasurementService;
import com.bridgeLabz.service.QuantityMeasurementServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/quantities")
public class QuantityMeasurementController {

    private final QuantityMeasurementServiceImpl service;

    public QuantityMeasurementController(QuantityMeasurementServiceImpl service) {
        this.service = service;
    }

    @PostMapping("/save")
    public QuantityMeasurementEntity save(@RequestBody QuantityMeasurementEntity entity) {
        return service.save(entity);
    }

    @GetMapping("/all")
    public List<QuantityMeasurementEntity> getAll() {
        return service.getAll();
    }

    @GetMapping("/operation/{op}")
    public List<QuantityMeasurementEntity> getByOperation(@PathVariable String op) {
        return service.getByOperation(op);
    }
}