package com.example.carmanager.controller;

import com.example.carmanager.dto.IMaxPrice;
import com.example.carmanager.model.Car;
import com.example.carmanager.model.Producer;
import com.example.carmanager.service.car.ICarService;
import com.example.carmanager.service.producer.IProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cars")
@CrossOrigin("*")
public class CarController {
    @Autowired
    private ICarService carService;
    @Autowired
    private IProducerService producerService;

    @GetMapping()
    public ResponseEntity<Iterable<Car>> showAllCar() {
        return new ResponseEntity<>(carService.findAll(),HttpStatus.OK);
    }

    @GetMapping("/producers")
    public ResponseEntity<Iterable<Producer>> showAllProducer() {
        return new ResponseEntity<>(producerService.findAll(),HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Car> create(@RequestBody Car car) {
        return new ResponseEntity<>(carService.save(car),HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Car> edit(@PathVariable Long id,@RequestBody Car car) {
        Optional<Car> optionalCar = carService.findById(id);
        car.setId(optionalCar.get().getId());
        return new ResponseEntity<>(carService.save(car),HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Car> delete(@PathVariable Long id) {
        Optional<Car> optionalCar = carService.findById(id);
        if (optionalCar.isPresent()) {
            carService.remove(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Car> findOneById(@PathVariable Long id) {
        Optional<Car> carOptional = carService.findById(id);
        Car car = carOptional.get();
        return new ResponseEntity<>(car,HttpStatus.OK);
    }

    @GetMapping("/price")
    public ResponseEntity<Iterable<IMaxPrice>> maxPrice() {
        Iterable<IMaxPrice> iMaxPrices = carService.getMaxPrice();
        return new ResponseEntity<>(iMaxPrices,HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Car>> findAllByName (@RequestParam("name") String name) {
        try{
            List<Car> list = carService.findByName(name);
            return new ResponseEntity<>(list,HttpStatus.OK);
        }catch (IllegalArgumentException e) {
            return new ResponseEntity<>(new ArrayList<>(),HttpStatus.OK);
        }
    }
}
