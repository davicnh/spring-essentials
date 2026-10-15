package org.example.springessentials.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.example.springessentials.database.entity.Assesstment;
import org.example.springessentials.dto.StudentDTO;
import org.example.springessentials.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/students")
@AllArgsConstructor
@Validated
public class StudentController {

    private StudentService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@Valid @RequestBody StudentDTO dto) {
        service.create(dto);
    }

    @GetMapping("/{id}/assesstment")
    @ResponseStatus(HttpStatus.OK)
    public Assesstment getAssesstment(@PathVariable UUID id) {
        return service.getStudentAssetment(id);
    }
}
