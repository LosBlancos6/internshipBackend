package com.intens.proj.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CreateUserSkillRequest {

    private Long userId;

    private Long skillId;

}
