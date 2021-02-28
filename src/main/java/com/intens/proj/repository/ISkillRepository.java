package com.intens.proj.repository;

import com.intens.proj.entity.Skill;
import com.intens.proj.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISkillRepository extends JpaRepository<Skill, Long> {

    Skill findOneById(Long id);

    Skill findByName(String name);
}
