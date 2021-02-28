package com.intens.proj.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Skill extends BaseEntity {

    private String name;

//    @OneToMany(mappedBy = "skill", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<User_Skill> user_skill = new ArrayList<>();

    @ManyToMany(mappedBy = "skills")
    private Set<User> users;

}
