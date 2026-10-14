package org.example.springessentials.database.repository;

import org.example.springessentials.database.entity.Exercises;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ExercisesRepository extends JpaRepository<Exercises, UUID> {
}
