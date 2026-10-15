package org.example.springessentials.service;

import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.example.springessentials.database.entity.Assesstment;
import org.example.springessentials.database.entity.Student;
import org.example.springessentials.database.repository.AssesstmentRepository;
import org.example.springessentials.database.repository.StudentRepository;
import org.example.springessentials.dto.AssesstmentDTO;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;

@Service
@RequiredArgsConstructor
public class AssestmentService {

    private final StudentRepository studentRepository;
    private final AssesstmentRepository assesstmentRepository;


    public void create(AssesstmentDTO dto) throws ChangeSetPersister.NotFoundException {
        Student student = studentRepository.findById(dto.getStudentId())
                .orElseThrow(() -> new EntityNotFoundException("Student not found: " + dto.getStudentId()));

        Assesstment assesstment = student.getAssesstment();
        if (assesstment != null) {
            throw new RuntimeException("Assesstment already done");
        }
        assesstment = Assesstment.builder()
                .weight(dto.getWeight())
                .height(dto.getHeight())
                .bodyFat(dto.getBodyFat())
                .build();

        student.setAssesstment(assesstment);
        studentRepository.save(student);
    }
}
