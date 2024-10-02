package com.example.restapistudy.service;

import com.example.restapistudy.domain.Student;
import com.example.restapistudy.dto.StudentDto;
import com.example.restapistudy.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) { // 생성자
        this.studentRepository = studentRepository;
    }

    public void saveStudent(StudentDto studentDto) {
        Student student = studentDto.toEntity();

        studentRepository.save(student);
    }

    public StudentDto findStudentById(Long id) {
        Student student = studentRepository.findById(id);

        return StudentDto.builder()
                .id(student.getId())
                .name(student.getName())
                .number(student.getNumber())
                .major(student.getMajor())
                .grade(student.getGrade())
                .build();
    }

    public List<StudentDto> findAllStudents() {
        return studentRepository.findAll()
                .stream()
                .map(student -> {
                    return StudentDto.builder()
                            .id(student.getId())
                            .name(student.getName())
                            .number(student.getNumber())
                            .major(student.getMajor())
                            .grade(student.getGrade())
                            .build();
                })
                .toList();
    }

    public void updateStudentById(Long id, StudentDto studentDto) {
        Student student = studentDto.toEntity();
        student.initId(id);

        studentRepository.updateById(id, student);
    }

    public void deleteStudentById(Long id) { // 노래 삭제 메서드
        studentRepository.deleteById(id);
    }
}
