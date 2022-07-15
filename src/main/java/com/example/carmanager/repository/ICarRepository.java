package com.example.carmanager.repository;

import com.example.carmanager.dto.IMaxPrice;
import com.example.carmanager.model.Car;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICarRepository extends CrudRepository<Car,Long> {
    @Query(nativeQuery = true,value = "select cars.id,cars.name as 'name',price,p.name as 'producer' from cars join producers p on p.id = cars.producer_id where price = (select max(price) from cars);")
    Iterable<IMaxPrice> getMaxPrice();
    @Query(nativeQuery = true,value = "select * from cars where (cars.name) like lower(concat('%', :name, '%'));")
    List<Car> findByName(@Param("name") String name);
}
