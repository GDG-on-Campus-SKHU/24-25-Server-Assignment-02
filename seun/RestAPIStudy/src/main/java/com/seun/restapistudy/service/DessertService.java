package com.seun.restapistudy.service;

import com.seun.restapistudy.domain.Dessert;
import com.seun.restapistudy.repository.DessertRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DessertService {

    private final DessertRepository dessertRepository;

    @Autowired
    public DessertService(DessertRepository dessertRepository) {
        this.dessertRepository = dessertRepository;
    }

    public void addDessert(Dessert dessert) {
        dessertRepository.save(dessert);
    }

    public Dessert getDessertById(Long id) {
        return dessertRepository.findById(id);
    }

    public List<Dessert> getAllDesserts() {
        return dessertRepository.findAll();
    }

    public List<Dessert> getDessertsByName(String name) {
        return dessertRepository.findByName(name);
    }

    public List<Dessert> getDessertsByType(String type) {
        return dessertRepository.findByType(type);
    }

    public boolean dessertExists(Long id) {
        return dessertRepository.existsById(id);
    }

    public long countDesserts() {
        return dessertRepository.count();
    }

    public void removeAllDesserts() {
        dessertRepository.deleteAll();
    }

    public void updateDessert(Long id, String newName, String newDescription, Double newPrice, Integer newCalories) {
        Dessert dessert = getDessertById(id);

        if (newName != null) dessert.setName(newName);
        if (newDescription != null) dessert.setDescription(newDescription);
        if (newPrice != null) dessert.setPrice(newPrice);
        if (newCalories != null) dessert.setCalories(newCalories);

        dessertRepository.update(dessert);
    }

    public void removeDessertById(Long id) {
        if (dessertRepository.existsById(id)) {
            dessertRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("ID " + id + "의 디저트가 존재하지 않습니다.");
        }
    }
}
