package com.seun.restapistudy.controller;

import com.seun.restapistudy.domain.Dessert;
import com.seun.restapistudy.service.DessertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/desserts")
public class DessertController {

    private final DessertService dessertService;

    @Autowired
    public DessertController(DessertService dessertService) {
        this.dessertService = dessertService;
    }

    @PostMapping
    public ResponseEntity<Void> addDessert(@RequestBody Dessert dessert) {
        dessertService.addDessert(dessert);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Dessert> getDessertById(@PathVariable Long id) {
        Dessert dessert = dessertService.getDessertById(id);
        return ResponseEntity.ok(dessert);
    }

    @GetMapping
    public ResponseEntity<List<Dessert>> getAllDesserts() {
        List<Dessert> desserts = dessertService.getAllDesserts();
        return ResponseEntity.ok(desserts);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Dessert>> searchDesserts(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String type) {
        List<Dessert> desserts;
        if (name != null) {
            desserts = dessertService.getDessertsByName(name);
        } else if (type != null) {
            desserts = dessertService.getDessertsByType(type);
        } else {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(desserts);
    }

    @GetMapping("/{id}/exists")
    public ResponseEntity<Boolean> dessertExists(@PathVariable Long id) {
        boolean exists = dessertService.dessertExists(id);
        return ResponseEntity.ok(exists);
    }

    @GetMapping("/count")
    public ResponseEntity<Long> countDesserts() {
        long count = dessertService.countDesserts();
        return ResponseEntity.ok(count);
    }

    @DeleteMapping
    public ResponseEntity<Void> removeAllDesserts() {
        dessertService.removeAllDesserts();
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateDessert(
            @PathVariable Long id,
            @RequestParam(required = false) String newName,
            @RequestParam(required = false) String newDescription,
            @RequestParam(required = false) Double newPrice,
            @RequestParam(required = false) Integer newCalories) {
        dessertService.updateDessert(id, newName, newDescription, newPrice, newCalories);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removeDessertById(@PathVariable Long id) {
        dessertService.removeDessertById(id);
        return ResponseEntity.noContent().build();
    }
}
