package com.bridgeLabz.service;

import com.bridgeLabz.dto.QuantityDTO;
import com.bridgeLabz.entity.QuantityMeasurementEntity;

public interface IQuantityMeasurementService {

    QuantityMeasurementEntity compare(QuantityDTO q1, QuantityDTO q2);

    QuantityMeasurementEntity add(QuantityDTO q1, QuantityDTO q2);


}