package org.example.springessentials.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.example.springessentials.dto.WorkoutDTO;
import org.example.springessentials.service.WorkoutsService;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/workouts")
@AllArgsConstructor
@Validated
public class WorkoutsController {

    private final WorkoutsService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@Valid @RequestBody WorkoutDTO dto) {
        service.create(dto);
    }
}
