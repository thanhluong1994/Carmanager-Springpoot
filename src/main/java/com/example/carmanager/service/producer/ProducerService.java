package com.example.carmanager.service.producer;


import com.example.carmanager.model.Producer;
import com.example.carmanager.repository.IProducerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProducerService implements IProducerService{
    @Autowired
    private IProducerRepository producerRepository;
    @Override
    public Iterable<Producer> findAll() {
        return producerRepository.findAll();
    }

    @Override
    public Optional<Producer> findById(Long id) {
        return producerRepository.findById(id);
    }

    @Override
    public Producer save(Producer producer) {
        return producerRepository.save(producer);
    }

    @Override
    public void remove(Long id) {
        producerRepository.deleteById(id);
    }
}
