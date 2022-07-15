package com.example.carmanager.service.car;

import com.example.carmanager.dto.IMaxPrice;
import com.example.carmanager.model.Car;
import com.example.carmanager.repository.ICarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarService implements ICarService{
    @Autowired
    private ICarRepository carRepository;
    @Override
    public Iterable findAll() {
        return carRepository.findAll();
    }

    @Override
    public Optional findById(Long id) {
        return carRepository.findById(id);
    }

    @Override
    public Car save(Car car) {
        return carRepository.save(car);
    }

    @Override
    public void remove(Long id) {
        carRepository.deleteById(id);
    }

    @Override
    public Iterable<IMaxPrice> getMaxPrice() {
        return carRepository.getMaxPrice();
    }

    @Override
    public List<Car> findByName(String name) {
        if (name==null || name.equals("")) {
            throw new IllegalArgumentException("Name is required");
        }
        return carRepository.findByName(name);
    }
    }


