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
    public Optional<Dessert> findById(Long id) {
        Dessert dessert = dessertMap.get(id);
        return Optional.ofNullable(dessert);
    }

    @Override
    public List<Dessert> findAll() {
        return new ArrayList<>(dessertMap.values());
    }

    @Override
    public Optional<List<Dessert>> findByNameOrType(String name, String type) {
        List<Dessert> results = dessertMap.values().stream()
                .filter(dessert -> (dessert.getName().equalsIgnoreCase(name)) ||
                        (dessert.getType().equalsIgnoreCase(type)))
                .collect(Collectors.toList());
        return Optional.ofNullable(results.isEmpty() ? null : results);
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
