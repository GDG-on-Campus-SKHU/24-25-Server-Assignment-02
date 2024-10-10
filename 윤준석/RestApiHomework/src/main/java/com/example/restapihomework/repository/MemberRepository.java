package com.example.restapihomework.repository; //회원 데이터를 저장하고 관리하기 위한 메서드 선언

import com.example.restapihomework.domain.Member;

import java.util.List;

//인터페이스 선언을 하고 실제 구현은 정의된 클래스에서 해야 함.
public interface MemberRepository {
    Member save(Member member); //멤버 객체를 인자로 하여 저장소에 저장함

    Member findById(Long id); //id를 인자로 받아 id에 해당하는 회원정보를 반환

    List<Member> findAll(); //저장소의 모든 멤버 객체를 리스트로 반환

    void updateById(Long id, Member member); //id를 기반으로 회원 정보를 수정

    void deleteById(Long id); //id를 기반으로 회원 정보를 삭제
}
