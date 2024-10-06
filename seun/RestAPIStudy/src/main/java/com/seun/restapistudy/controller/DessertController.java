package com.seun.restapistudy.controller;

import com.seun.restapistudy.domain.Dessert;
import com.seun.restapistudy.dto.DessertDto;
import com.seun.restapistudy.service.DessertService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/desserts")
public class DessertController {

    private final DessertService dessertService;

    public DessertController(DessertService dessertService) {
        this.dessertService = dessertService;
    }

    @PostMapping
    public ResponseEntity<Void> addDessert(@RequestBody DessertDto dessertDTO) {
        dessertService.addDessert(dessertDTO);
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
        List<Dessert> desserts = dessertService.searchDesserts(name, type);
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
            @RequestParam(required = false) Long newPrice,
            @RequestParam(required = false) Long newCalories) {
        dessertService.updateDessert(id, newName, newDescription, newPrice, newCalories);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removeDessertById(@PathVariable Long id) {
        dessertService.removeDessertById(id);
        return ResponseEntity.noContent().build();
    }
}
