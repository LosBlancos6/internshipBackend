package com.intens.proj.service.impl;

import com.intens.proj.dto.request.CreateSkillRequest;
import com.intens.proj.dto.response.SkillResponse;
import com.intens.proj.entity.Skill;
import com.intens.proj.entity.User;
import com.intens.proj.repository.ISkillRepository;
import com.intens.proj.repository.IUserRepository;
import com.intens.proj.service.ISkillService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class SkillService implements ISkillService {

    private final ISkillRepository _skillRepository;

    private final IUserRepository _userRepository;

    public SkillService(ISkillRepository skillRepository, IUserRepository userRepository) {
        _skillRepository = skillRepository;
        _userRepository = userRepository;
    }

    @Override
    public SkillResponse createSkill(CreateSkillRequest request) {

        Skill skill = new Skill();
        skill.setName(request.getName());

        Skill savedSkill = _skillRepository.save(skill);

        return mapSkillToSkillResponse(savedSkill);
    }

    @Override
    public void deleteSkill(Long id) throws Exception {
        Skill skill = _skillRepository.findOneById(id);

        if(skill == null) {
            throw new Exception(String.format("user with %s id is not found", id));
        }

        _skillRepository.delete(skill);
    }

    @Override
    public SkillResponse getSkill(Long id) throws Exception {
        Skill skill = _skillRepository.findOneById(id);

        if(skill == null) {
            throw new Exception(String.format("skill with %s id is not found", id));
        }

        return mapSkillToSkillResponse(skill);
    }

    @Override
    public List<SkillResponse> getAllSkills() {
        List<Skill> skills = _skillRepository.findAll() ;

        return skills
                .stream()
                .map(skill -> mapSkillToSkillResponse(skill))
                .collect(Collectors.toList());
    }

    @Override
    public SkillResponse updateSkill(Long id, CreateSkillRequest request) throws Exception {
        Skill skill = _skillRepository.findOneById(id);

        if(skill == null) {
            throw new Exception(String.format("skill with %s id is not found", id));
        }

        skill.setName(request.getName());

        Skill savedSkill = _skillRepository.save(skill);

        return mapSkillToSkillResponse(savedSkill);
    }

    @Override
    public List<SkillResponse> getAllSkillsByUser(Long id) throws Exception {
        User user = _userRepository.findOneById(id) ;

        if(user == null) {
            throw new Exception(String.format("skill with %s id is not found", id));
        }

        Set<Skill> skills = user.getSkills();

        return skills
                .stream()
                .map(skill -> mapSkillToSkillResponse(skill))
                .collect(Collectors.toList());
    }

    SkillResponse mapSkillToSkillResponse(Skill skill) {
        SkillResponse skillResponse = new SkillResponse();
        skillResponse.setId(skill.getId());
        skillResponse.setName(skill.getName());
        return skillResponse;
    }
}
