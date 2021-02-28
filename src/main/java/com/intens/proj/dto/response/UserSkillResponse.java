package com.intens.proj.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserSkillResponse {

    private Long userId;

    private Long skillId;

}
