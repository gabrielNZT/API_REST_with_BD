package com.example.API_implementation;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controller{
    private final Repository repository;

    public Controller(Repository repository) {
        this.repository = repository;
    }

    @GetMapping("/")
    public String Init(){
        return ("CARS STORE");
    }

    @GetMapping("/cars")
    public List<Car> findAll(){
        return repository.findAll();
    }

    @PostMapping("/employees")
    Car newEmployee(@RequestBody Car newCar){
        return repository.save(newCar);
    }

    @GetMapping("/cars/{id}")
    public Car findByID(@PathVariable Long id){
        return repository.findById(id).orElseThrow(() -> new NotFoundExcpetion(id));
    }

    @PutMapping("/cars/{id}")
    Car updateCar(@RequestBody Car newCar, Long id){
        return repository.findById(id).map(car -> {
            car.setMarca(newCar.getMarca());
            car.setModelo(newCar.getModelo());
            return repository.save(newCar);
        }).orElseGet(() -> {
            newCar.setId(id);
            return repository.save(newCar);
        });
    }

    @DeleteMapping("/cars/{id}")
    void deleteCar(@PathVariable Long id){
        repository.deleteById(id);
    }
}
