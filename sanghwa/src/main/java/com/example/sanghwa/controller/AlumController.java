package com.example.sanghwa.controller;

import com.example.sanghwa.dto.MenteeDto;
import com.example.sanghwa.dto.MentoDto;
import com.example.sanghwa.repository.MembersRepository;
import com.example.sanghwa.service.AlumService;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Member;
import java.util.List;

@RestController
public class AlumController {
    private final AlumService alumService;

    public AlumController(AlumService alumService) {
        this.alumService = alumService;
    }

    @PostMapping("alum/mentee") //??
    public void saveMemberMentee(@RequestBody MenteeDto menteeDto) {
        alumService.saveMemberMentee(menteeDto); //이 메서드 안에서 entity로 변환
    }
    @PostMapping("alum/mento")
    public void saveMemberMento(@RequestBody MentoDto mentoDto) {
        alumService.saveMemberMento(mentoDto);
    }
    // 멘티 리스트
    @GetMapping("alum/mentee/list")
    public List<MenteeDto> showAllMentee() {
        return alumService.showAllMentee();
    }
    // 멘토 리스트
    @GetMapping("alum/mento/list")
    public List<MentoDto> showAllMento() {
        return alumService.showAllMento();
    }
    @GetMapping("alum/mentee/{id}")
    public MenteeDto showMenteeById(@PathVariable Long id) {
        return alumService.showMenteeById(id);
    }
    @GetMapping("alum/mento/{id}")
    public MentoDto showMentoById(@PathVariable Long id) {
        return alumService.showMentoById(id);
    }
    // 멘티의 major 수정
    @PatchMapping("alum/{id}/mentee/{major}")
    public void updateMenteeMajorById(@PathVariable Long id, @PathVariable String major) {
        alumService.updateMenteeMajorById(id, major);
    } //멘토의 job 수정
    @PatchMapping("alum/{id}/mento/{job}")
    public void updateMenteeJobById(@PathVariable Long id, @PathVariable String job) {
        alumService.updateMentoJobById(id, job);
    }

    @DeleteMapping("alum/mentee/{id}")
    public void deleteMenteeById(@PathVariable Long id) {
        alumService.deleteMenteeById(id);
    }
    @DeleteMapping("alum/mento/{id}")
    public void deleteMentoById(@PathVariable Long id) {
        alumService.deleteMentoById(id);
    }








}
