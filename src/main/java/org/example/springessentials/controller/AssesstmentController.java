package org.example.springessentials.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.example.springessentials.dto.AssesstmentDTO;
import org.example.springessentials.service.AssestmentService;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("assestments")
@AllArgsConstructor
@Validated
public class AssesstmentController {

    private final AssestmentService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@Valid @RequestBody AssesstmentDTO dto) throws ChangeSetPersister.NotFoundException {
        service.create(dto);
    }
}
