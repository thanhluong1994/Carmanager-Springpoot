package com.example.carmanager.controller;


import com.example.carmanager.model.Producer;
import com.example.carmanager.service.producer.IProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/producers")
@CrossOrigin("*")
public class ProducerController {
    @Autowired
    private IProducerService producerService;

    //hien thi danh sach cac hang xe
    @GetMapping("")
    public ResponseEntity<Iterable<Producer>> showAll() {
        return new ResponseEntity<>(producerService.findAll(), HttpStatus.OK);
    }
    // Them moi hang xe
    @PostMapping()
    public ResponseEntity<Producer> createNew (@RequestBody Producer producer) {
        return new ResponseEntity<>(producerService.save(producer),HttpStatus.OK);
    }
    //Sua thong tin hang xe
    @PutMapping("/{id}")
    public ResponseEntity<Producer> edit(@PathVariable Long id, @RequestBody Producer producer) {
        Optional<Producer> optionalProducer = producerService.findById(id);
        if (optionalProducer.isPresent()) {
            producer.setId(optionalProducer.get().getId());
            return new ResponseEntity<>(producerService.save(producer), HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    //Xoa hang xe
    @DeleteMapping("/{id}")
    public ResponseEntity<Producer> delete(@PathVariable Long id) {
        Optional<Producer> optionalProducer = producerService.findById(id);
        if (optionalProducer.isPresent()) {
            producerService.remove(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
