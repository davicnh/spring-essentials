package org.example.springessentials.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.example.springessentials.database.entity.Exercises;
import org.example.springessentials.dto.ExercisesDTO;
import org.example.springessentials.service.ExercisesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/exercises")
@AllArgsConstructor
@Validated
public class ExercisesController {

    private final ExercisesService service;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Exercises> findAll() {
        return service.findAll();
    }

    @GetMapping("/groups/{group}")
    @ResponseStatus(HttpStatus.OK)
    public List<Exercises> findAllByMuscularGroup(@PathVariable String group) {
        return service.findByMuscularGroup(group);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@Valid @RequestBody ExercisesDTO dto) {
        service.save(dto);
    }

}
