package com.seun.restapistudy.service;

import com.seun.restapistudy.domain.Dessert;
import com.seun.restapistudy.dto.DessertDto;
import com.seun.restapistudy.repository.DessertRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class DessertService {

    private final DessertRepository dessertRepository;

    public DessertService(DessertRepository dessertRepository) {
        this.dessertRepository = dessertRepository;
    }

    public void addDessert(DessertDto dessertDTO) {
        Dessert dessert = dessertDTO.toEntity();
        dessertRepository.save(dessert);
    }

    public Dessert getDessertById(Long id) {
        return dessertRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("디저트를 찾을 수 없습니다: " + id));
    }

    public List<Dessert> getAllDesserts() {
        return dessertRepository.findAll();
    }

    public List<Dessert> searchDesserts(String name, String type) {
        return dessertRepository.findByNameOrType(name, type)
                .orElseThrow(() -> new IllegalArgumentException("이름이나 타입에 해당하는 디저트가 없습니다."));
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

    public void updateDessert(Long id, String newName, String newDescription, Long newPrice, Long newCalories) {
        if (id == null) {
            throw new IllegalArgumentException("ID는 null일 수 없습니다.");
        }

        Dessert dessert = dessertRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("ID " + id + "의 디저트를 찾을 수 없습니다."));

        if (newName != null) dessert.setName(newName);
        if (newDescription != null) dessert.setDescription(newDescription);
        if (newPrice != null) dessert.setPrice(newPrice);
        if (newCalories != null) dessert.setCalories(newCalories);

        dessertRepository.update(dessert);
    }


    public void removeDessertById(Long id) {
        Dessert dessert = dessertRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("ID " + id + "의 디저트가 존재하지 않습니다."));

        dessertRepository.deleteById(id);
    }

}
