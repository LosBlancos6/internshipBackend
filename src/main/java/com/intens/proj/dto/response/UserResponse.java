package com.intens.proj.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserResponse {

    private Long id;

    private String name;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date dateOfBirth;

    private int number;

    private String email;

}
