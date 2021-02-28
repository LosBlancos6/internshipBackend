package com.intens.proj.service.impl;

import com.intens.proj.dto.response.SkillResponse;
import com.intens.proj.entity.Skill;
import com.intens.proj.repository.ISkillRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(MockitoJUnitRunner.class)
class SkillServiceTest {

    @InjectMocks
    SkillService skillService;

    @Mock
    ISkillRepository skillRepository;

    @Test
    void getAllSkillsTest() {
//        List<SkillResponse> skills = new ArrayList<SkillResponse>();
//        SkillResponse skillResponse = new SkillResponse(1L, "java");
//
//        skills.add(skillResponse);
//
//        Mockito.when(skillRepository.findAll()).thenReturn(skills);
//
//        List<SkillResponse> skillList = skillService.getAllSkills();
//
//        assertEquals(1, skillList.size());
//        Mockito.verify(skillRepository, Mockito.times(1)).findAll();
    }
}