package org.example.springessentials.service;

import lombok.RequiredArgsConstructor;
import org.example.springessentials.database.entity.Exercises;
import org.example.springessentials.database.entity.Student;
import org.example.springessentials.database.entity.Workouts;
import org.example.springessentials.database.repository.ExercisesRepository;
import org.example.springessentials.database.repository.StudentRepository;
import org.example.springessentials.database.repository.WorkoutsRepository;
import org.example.springessentials.dto.WorkoutDTO;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class WorkoutsService {

    private final StudentRepository studentRepository;
    private final ExercisesRepository exercisesRepository;
    private final WorkoutsRepository workoutsRepository;

    public void create(WorkoutDTO dto) {

        Set<Exercises> exercisesSet = new HashSet<>();

        Student student = studentRepository.findById(dto.getStudentID())
                .orElseThrow(null);

        Workouts workout = workoutsRepository.findByNameAndStudentID(
                dto.getWorkoutName(),
                dto.getStudentID())
                .orElseThrow(null);

        if (workout != null) {
            throw new RuntimeException("Workout already exists");
        }

        for (UUID exercisesID : dto.getExercisesIDs()) {
            Exercises exercises = exercisesRepository.findById(exercisesID).orElseThrow(null);

            exercisesSet.add(exercises);
        }

        workout = Workouts.builder()
                .name(dto.getWorkoutName())
                .student(student)
                .exercises(exercisesSet)
                .build();

        workoutsRepository.save(workout);
    }
}
