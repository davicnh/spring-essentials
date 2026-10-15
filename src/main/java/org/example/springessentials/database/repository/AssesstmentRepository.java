package org.example.springessentials.database.repository;

import org.example.springessentials.database.entity.Assesstment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.NativeQuery;

import java.util.List;
import java.util.UUID;

public interface AssesstmentRepository extends JpaRepository<Assesstment, UUID> {
}
