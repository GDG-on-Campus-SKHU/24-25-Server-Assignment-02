package com.example.restapistudy.controller;

import com.example.restapistudy.dto.StudentDto;
import com.example.restapistudy.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    private final StudentService studentService;
    
    // 생성자 주입
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("addstudent") // 학생 정보 저장
    public void save(@RequestBody StudentDto studentDto) {
        studentService.saveStudent(studentDto);
    }

    @GetMapping("student/{id}") // id에 맞는 학생의 정보 불러오기
    public StudentDto findStudentById(@PathVariable Long id) {
        return studentService.findStudentById(id);
    }

    @GetMapping("student/list") // 모든 학생 정보 리스트 불러오기
    public List<StudentDto> findAllStudents() {
        return studentService.findAllStudents();
    }

    @PatchMapping("updatestudent/{id}") // id에 맞는 학생의 정보 수정하기
    public void updateStudentById(@PathVariable Long id, @RequestBody StudentDto studentDto) {
        studentService.updateStudentById(id, studentDto);
    }

    @DeleteMapping("delstudent/{id}") // id에 맞는 학생의 정보 삭제하기
    public void deleteStudentById(@PathVariable Long id) {
        studentService.deleteStudentById(id);
    }
}
