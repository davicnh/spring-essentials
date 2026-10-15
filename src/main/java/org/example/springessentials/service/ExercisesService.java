package org.example.springessentials.service;

import lombok.RequiredArgsConstructor;
import org.example.springessentials.database.entity.Exercises;
import org.example.springessentials.database.repository.ExercisesRepository;
import org.example.springessentials.dto.ExercisesDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExercisesService {

    private final ExercisesRepository repository;

    public List<Exercises> findAll() {
        return repository.findAll();
    }

    public void save(ExercisesDTO dto) {
        repository.save(Exercises.builder()
                .name(dto.getName())
                .muscularGroup(dto.getMuscularGroup())
                .build());
    }

    public List<Exercises> findByMuscularGroup(String muscularGroup) {
        return repository.findByMuscularGroup(muscularGroup);
    }
}
