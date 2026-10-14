package org.example.springessentials.database.repository;

import org.example.springessentials.database.entity.Workouts;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface WorkoutsRepository extends JpaRepository<Workouts, UUID> {
}
