package com.example.carmanager.service.car;

import com.example.carmanager.dto.IMaxPrice;
import com.example.carmanager.model.Car;
import com.example.carmanager.service.IGeneralService;

public interface ICarService extends IGeneralService <Car>{
    Iterable<IMaxPrice> getMaxPrice();
}
