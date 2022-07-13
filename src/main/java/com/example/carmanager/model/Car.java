package com.example.carmanager.model;

import javax.persistence.*;

@Entity
@Table(name = "cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int price;
    @ManyToOne
    @JoinColumn(name = "producer_id")
    private Producer producer;

    public Car() {
    }

    public Car(Long id, String name, int price, Producer producer) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.producer = producer;
    }

    public Car(String name, int price, Producer producer) {
        this.name = name;
        this.price = price;
        this.producer = producer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Producer getProducer() {
        return producer;
    }

    public void setProducer(Producer producer) {
        this.producer = producer;
    }
}
