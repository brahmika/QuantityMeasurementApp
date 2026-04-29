package com.bridgeLabz.app;

import com.bridgeLabz.controller.QuantityMeasurementController;
import com.bridgeLabz.dto.QuantityDTO;
import com.bridgeLabz.repository.IQuantityMeasurementRepository;
import com.bridgeLabz.repository.QuantityMeasurementCacheRepository;
import com.bridgeLabz.service.IQuantityMeasurementService;
import com.bridgeLabz.service.QuantityMeasurementServiceImpl;

public class QuantityMeasurementAppp {

    public static void main(String[] args) {

        // Repository
        IQuantityMeasurementRepository repo =
                QuantityMeasurementCacheRepository.getInstance();

        // Service
        IQuantityMeasurementService service =
                new QuantityMeasurementServiceImpl(repo);

        // Controller
        QuantityMeasurementController controller =
                new QuantityMeasurementController(service);

        // TEST DATA
        QuantityDTO q1 = new QuantityDTO(10, "feet");
        QuantityDTO q2 = new QuantityDTO(10, "feet");

        controller.performComparison(q1, q2);
        controller.performAddition(q1, q2);
    }
}