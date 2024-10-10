package com.example.restapihomework.repository;

import com.example.restapihomework.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MemoryMemberRepository implements MemberRepository {
    public static Map<Long, Member> store = new HashMap<>();

    @Override //입력받은 id로 회원명 저장
    public Member save(Member member) {
        store.put(member.getId(), member);
        return member;
    }

    @Override //id(key)로 회원명 찾기
    public Member findById(Long id) {
        return store.get(id);
    }

    @Override //id 기준으로 오름차순 정렬
    public List<Member> findAll() {
        List<Member> members = new ArrayList<>(store.values());
        members.sort(Comparator.comparing(Member::getId));
        return members;
    }
    @Override //새로운 내용으로 초기화
    public void updateById(Long id, Member member) {
        store.put(id, member);
    }

    @Override //id로 노래 검색
    public void deleteById(Long id) {
        store.remove(id);
    }
}
