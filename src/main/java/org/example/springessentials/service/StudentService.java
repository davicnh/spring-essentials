package org.example.springessentials.service;

import lombok.RequiredArgsConstructor;
import org.example.springessentials.database.entity.Assesstment;
import org.example.springessentials.database.entity.Student;
import org.example.springessentials.database.repository.StudentRepository;
import org.example.springessentials.dto.StudentDTO;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository repository;

    public void create(StudentDTO dto) {
        Student student = repository.findByEmail(dto.getEmail())
                .orElseThrow(null);

        if (student != null) {
            throw new RuntimeException("Student already exists");
        }

        repository.save(Student.builder()
                .name(dto.getName())
                .email(dto.getEmail())
                .build()
        );
    }

    public Assesstment getStudentAssetment(UUID id) {
        Student student = repository.findById(id).orElseThrow(() -> new RuntimeException("Student not found"));

        Assesstment assesstment = student.getAssesstment();
        if (assesstment == null) {
            throw new RuntimeException("Assessment not found");
        }
        return assesstment;
    }
}
