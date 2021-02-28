package com.intens.proj.service;

import com.intens.proj.dto.request.CreateSkillRequest;
import com.intens.proj.dto.response.SkillResponse;

import java.util.List;
import java.util.Set;

public interface ISkillService {

    SkillResponse createSkill(CreateSkillRequest request);

    SkillResponse getSkill(Long id) throws Exception;

    List<SkillResponse> getAllSkills();

    SkillResponse updateSkill(Long id, CreateSkillRequest request) throws Exception;

    void deleteSkill(Long id) throws Exception;

    List<SkillResponse> getAllSkillsByUser(Long id) throws Exception;

}
