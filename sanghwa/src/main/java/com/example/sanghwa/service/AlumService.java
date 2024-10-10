package com.example.sanghwa.service;

import com.example.sanghwa.domain.Mentee;
import com.example.sanghwa.domain.Mento;
import com.example.sanghwa.dto.MenteeDto;
import com.example.sanghwa.dto.MentoDto;
import com.example.sanghwa.repository.MembersRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AlumService {
    private final MembersRepository membersRepository;

    public AlumService(MembersRepository membersRepository) {
        this.membersRepository = membersRepository;
    }

    // mentee회원 저장
    public void saveMemberMentee(MenteeDto menteedto) {
        Mentee mentee = menteedto.dtoToMentee();
        membersRepository.menteeSave(mentee);
    }

    // mento회원 저장
    public void saveMemberMento(MentoDto mentoDto) {
        Mento mento = mentoDto.dtoToMento();
        membersRepository.mentoSave(mento);
    }

    //repo에서 entity타입의 member들을 Dto 객체로 전환해서 리스트 반환
    public List<MenteeDto> showAllMentee() {
        return membersRepository.findAllMentee()
                .stream()
                .map(mentee -> {
                    return MenteeDto.builder()
                            .id(mentee.getId())
                            .name(mentee.getName())
                            .major(mentee.getMajor())
                            .build();
                })
                .toList();
    }
    public List<MentoDto> showAllMento() {
        return membersRepository.findAllMento()
                .stream()
                .map(mento -> {
                    return MentoDto.builder()
                            .id(mento.getId())
                            .name(mento.getName())
                            .job(mento.getJob())
                            .build();
                })
                .toList();
    }
    // 한명의 menteem mento 찾기
    public MenteeDto showMenteeById(Long id) {
        Mentee mentee = membersRepository.findMenteeById(id);

        return MenteeDto.builder()      //
                .name(mentee.getName())
                .id(mentee.getId())
                .major(mentee.getMajor())
                .build();
    }
    public MentoDto showMentoById(Long id) {
        Mento mento = membersRepository.findMentoById(id);

        return MentoDto.builder()
                .id(mento.getId())
                .name(mento.getName())
                .job(mento.getJob())
                .build();
    }

    public void updateMenteeMajorById(Long id, String major) {
        membersRepository.menteeUpdateMajorById(id, major);
    }
    public void updateMentoJobById(Long id, String job) {
        membersRepository.mentoUpdateJobById(id, job);
    }

    public void deleteMenteeById(Long id) {
        membersRepository.menteeDeleteById(id);
    }
    public void deleteMentoById(Long id) {
        membersRepository.mentoDeleteById(id);
    }

}
