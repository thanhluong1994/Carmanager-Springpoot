package com.example.carmanager.service.car;

import com.example.carmanager.dto.IMaxPrice;
import com.example.carmanager.model.Car;
import com.example.carmanager.service.IGeneralService;

import java.util.List;

public interface ICarService extends IGeneralService <Car>{
    Iterable<IMaxPrice> getMaxPrice();

    List<Car> findByName(String name);
}
