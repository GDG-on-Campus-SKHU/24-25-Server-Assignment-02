package com.seun.restapistudy.repository;

import com.seun.restapistudy.domain.Dessert;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;

@Repository
public class MemoryDessertRepository implements DessertRepository {

    private final Map<Long, Dessert> dessertMap = new HashMap<>();
    private Long currentId = 1L;

    @Override
    public void save(Dessert dessert) {
        dessert.setId(generateNextId());
        dessertMap.put(dessert.getId(), dessert);
    }

    @Override
    public Dessert findById(Long id) {
        Dessert dessert = dessertMap.get(id);
        if (dessert == null) {
            throw new NoSuchElementException("디저트를 찾을 수 없습니다: " + id);
        }
        return dessert;
    }

    @Override
    public List<Dessert> findAll() {
        return new ArrayList<>(dessertMap.values());
    }

    @Override
    public List<Dessert> findByName(String name) {
        return dessertMap.values().stream()
                .filter(dessert -> dessert.getName().equalsIgnoreCase(name))
                .collect(Collectors.toList());
    }

    @Override
    public List<Dessert> findByType(String type) {
        return dessertMap.values().stream()
                .filter(dessert -> dessert.getType().equalsIgnoreCase(type))
                .collect(Collectors.toList());
    }

    @Override
    public boolean existsById(Long id) {
        return dessertMap.containsKey(id);
    }

    @Override
    public long count() {
        return dessertMap.size();
    }

    @Override
    public void deleteAll() {
        dessertMap.clear();
    }

    @Override
    public void update(Dessert dessert) {
        dessertMap.put(dessert.getId(), dessert);
    }

    @Override
    public void deleteById(Long id) {
        dessertMap.remove(id);
    }

    private Long generateNextId() {
        return currentId++;
    }
}
