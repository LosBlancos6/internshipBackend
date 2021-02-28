package com.intens.proj.service;

import com.intens.proj.dto.request.CreateUserRequest;
import com.intens.proj.dto.response.UserResponse;

import java.util.List;
import java.util.Set;

public interface IUserService {

    UserResponse createUser(CreateUserRequest request);

    UserResponse getUser(Long id) throws Exception;

    List<UserResponse> getAllUsers();

    UserResponse updateUser(Long id, CreateUserRequest request) throws Exception;

    void deleteUser(Long id) throws Exception;

    UserResponse assignSkillToUser(Long userId, Long skillId);

    UserResponse removeSkillFromUser(Long userId, Long skillId);

    List<UserResponse> getAllUsersBySkill(String name) throws Exception;

    List<UserResponse> getUserByName(String name) throws Exception;

}
