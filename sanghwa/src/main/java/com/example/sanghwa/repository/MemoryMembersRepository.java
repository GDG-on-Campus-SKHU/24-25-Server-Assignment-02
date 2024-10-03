package com.example.sanghwa.repository;

import com.example.sanghwa.domain.Mentee;
import com.example.sanghwa.domain.Mento;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Repository
public class MemoryMembersRepository implements MembersRepository {
    private static Map<Long, Mentee> menteeStore = new HashMap<>();
    private static Map<Long, Mento> mentoStore = new HashMap<>();

    @Override
    public void menteeSave(Mentee mentee) {
        menteeStore.put(mentee.getId(), mentee);
    }
    @Override
    public void mentoSave(Mento mento) {
        mentoStore.put(mento.getId(), mento);
    }
    @Override
    public List<Mentee> findAllMentee() {
        return menteeStore.values().stream().toList(); //List로 변환
    }
    @Override
    public List<Mento> findAllMento() {
        return mentoStore.values().stream().toList();
    }
    @Override
    public Mentee findMenteeById(Long id) {
        return menteeStore.get(id); //Id를 포함한 객체 전부를 가져오나? O
    }
    @Override
    public Mento findMentoById(Long id) {
        return mentoStore.get(id);
    }
    @Override
    //id값을 가지고 store에 저장되어있는 객체의 major를 수정
    public void menteeUpdateMajorById(Long id, String major) {
        Mentee mentee = menteeStore.get(id);
        mentee.setMajor(major);
        menteeStore.put(id, mentee); //중복 자동 삭제
    }
    @Override
    public void mentoUpdateJobById(Long id, String job) {
        Mento mento = mentoStore.get(id);
        mento.setJob(job);
        mentoStore.put(id, mento);
    }
    @Override
    public void menteeDeleteById(Long id){
        menteeStore.remove(id);
    }
    @Override
    public void mentoDeleteById(Long id){
        mentoStore.remove(id);
    }


}
