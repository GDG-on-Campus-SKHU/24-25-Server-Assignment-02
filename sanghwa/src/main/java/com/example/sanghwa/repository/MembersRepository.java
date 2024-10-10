package com.example.sanghwa.repository;

import com.example.sanghwa.domain.Mentee;
import com.example.sanghwa.domain.Mento;

import java.util.ArrayList;
import java.util.List;

public interface MembersRepository {

    //create
    void menteeSave(Mentee mentee);
    void mentoSave(Mento mento);

    //Read
    Mentee findMenteeById(Long id);
    Mento findMentoById(Long id);
    List<Mentee> findAllMentee();
    List<Mento> findAllMento();

    //Update Mentee
    void menteeUpdateMajorById(Long id, String major);
    //Update Mento
    void mentoUpdateJobById(Long id, String job);

    //Delete
    void menteeDeleteById(Long id);
    void mentoDeleteById(Long id);




}
