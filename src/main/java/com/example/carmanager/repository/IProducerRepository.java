package com.example.carmanager.repository;

import com.example.carmanager.model.Producer;
import org.springframework.data.repository.CrudRepository;

public interface IProducerRepository extends CrudRepository<Producer,Long> {
}