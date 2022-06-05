package com.example.API_implementation;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String modelo;
    private String marca;

    public Car(String modelo, String marca) {
        this.modelo = modelo;
        this.marca = marca;
        this.id = id;
    }

    public Car() {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", modelo='" + modelo + '\'' +
                '}';
    }
}
