package com.intens.proj.controller;

import com.intens.proj.dto.request.CreateSkillRequest;
import com.intens.proj.dto.response.SkillResponse;
import com.intens.proj.service.ISkillService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/skill")
public class SkillController {

    private final ISkillService _skillService;

    public SkillController(ISkillService skillService) {
        _skillService = skillService;
    }

    @PostMapping
    public SkillResponse createSkill(@RequestBody CreateSkillRequest request) {
        try {
            return _skillService.createSkill(request);
        } catch (Exception ex) {
            return null;
        }
    }

    @GetMapping("/{id}")
    public SkillResponse getSkill(@PathVariable Long id) {
        try {
            return _skillService.getSkill(id);
        } catch (Exception ex) {
            return null;
        }
    }

    @GetMapping
    public List<SkillResponse> getAllSkills(){
        try {
            return _skillService.getAllSkills();
        } catch (Exception ex) {
            return null;
        }
    }

    @PutMapping("/{id}")
    public SkillResponse updateSkill(@PathVariable Long id, @RequestBody CreateSkillRequest request) {
        try {
            return _skillService.updateSkill(id,request);
        } catch (Exception ex) {
            return null;
        }
    }

    @DeleteMapping("/{id}")
    public void deleteSkill(@PathVariable Long id) throws Exception {
        _skillService.deleteSkill(id);
    }


    @GetMapping("byUser/{id}")
    public List<SkillResponse> getAllSkillsByUser(@PathVariable Long id){
        try {
            return _skillService.getAllSkillsByUser(id);
        } catch (Exception ex) {
            return null;
        }
    }
}
