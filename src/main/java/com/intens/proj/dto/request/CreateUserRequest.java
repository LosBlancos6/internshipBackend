package com.intens.proj.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CreateUserRequest {

    private String name;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date dateOfBirth;

    private int number;

    private String email;

}
