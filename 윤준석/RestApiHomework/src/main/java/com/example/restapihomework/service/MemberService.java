package com.example.restapihomework.service;

import com.example.restapihomework.repository.MemberRepository;
import com.example.restapihomework.domain.Member;
import com.example.restapihomework.dto.MemberDto;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class MemberService {
    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public void saveMember(MemberDto memberDto) { //회원 정보 저장 메서드
        Member member = memberDto.toEntity();
        memberRepository.save(member);
    }

    public MemberDto findMemberById(Long id) { //회원 찾기 메서드
        Member member = memberRepository.findById(id);

        return MemberDto.builder()
                .id(member.getId())
                .name(member.getName())
                .phoneNumber(member.getPhoneNumber())
                .isEnrolled(member.getIsEnrolled())
                .ptTeacherName(member.getPtTeacherName())
                .build();
    }

    public List<MemberDto> findAllMembers() { //전체 회원 찾기 메서드
        return memberRepository.findAll()
                .stream()
                .map(member -> MemberDto.builder()
                        .id(member.getId())
                        .name(member.getName())
                        .phoneNumber(member.getPhoneNumber())
                        .isEnrolled(member.getIsEnrolled())
                        .ptTeacherName(member.getPtTeacherName())
                        .build())
                .collect(Collectors.toList());
    }

    public void updateMemberById(Long id, MemberDto memberDto) { //회원 정보 업데이트 메서드
        Member member = memberDto.toEntity();
        memberRepository.updateById(member.getId(), member);
    }

    public void deleteMemberById(Long id) { //회원 삭제 메서드
        memberRepository.deleteById(id);
    }
}