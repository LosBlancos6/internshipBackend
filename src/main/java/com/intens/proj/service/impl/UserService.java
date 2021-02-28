package com.intens.proj.service.impl;

import com.intens.proj.dto.request.CreateUserRequest;
import com.intens.proj.dto.response.UserResponse;
import com.intens.proj.entity.Skill;
import com.intens.proj.entity.User;
import com.intens.proj.repository.ISkillRepository;
import com.intens.proj.repository.IUserRepository;
import com.intens.proj.service.IUserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserService implements IUserService {

    private final IUserRepository _userRepository;

    private final ISkillRepository _skillRepository;

    public UserService(IUserRepository userRepository, ISkillRepository skillRepository) {
        _userRepository = userRepository;
        _skillRepository = skillRepository;
    }

    @Override
    public UserResponse createUser(CreateUserRequest request) {
        User user = new User();
        user.setEmail(request.getEmail());
        user.setName(request.getName());
        user.setNumber(request.getNumber());
        user.setDateOfBirth(request.getDateOfBirth());

        User savedUser = _userRepository.save(user);

        return mapUserToUserResponse(savedUser);
    }

    @Override
    public UserResponse getUser(Long id) throws Exception {
        User user = _userRepository.findOneById(id);

        if(user == null) {
            throw new Exception(String.format("user with %s id is not found", id));
        }

        return mapUserToUserResponse(user);
    }

    @Override
    public List<UserResponse> getAllUsers() {
        List<User> users = _userRepository.findAll();

        return users
                .stream()
                .map(user -> mapUserToUserResponse(user))
                .collect(Collectors.toList());
    }

    @Override
    public UserResponse updateUser(Long id, CreateUserRequest request) throws Exception {
        User user = _userRepository.findOneById(id);

        if(user == null) {
            throw new Exception(String.format("user with %s id is not found", id));
        }

        user.setName(request.getName());
        user.setDateOfBirth(request.getDateOfBirth());
        user.setNumber(request.getNumber());
        user.setEmail(request.getEmail());

        User savedUser = _userRepository.save(user);

        return mapUserToUserResponse(savedUser);
    }

    @Override
    public void deleteUser(Long id) throws Exception {
        User user = _userRepository.findOneById(id);

        if(user == null) {
            throw new Exception(String.format("user with %s id is not found", id));
        }

        _userRepository.delete(user);
    }

    @Override
    public List<UserResponse> getAllUsersBySkill(String name) throws Exception {
        Skill skill =  _skillRepository.findByName(name);

        if(skill == null) {
            throw new Exception(String.format("user with %s name is not found", name));
        }

        Set<User> users = skill.getUsers();

        return users
                .stream()
                .map(user -> mapUserToUserResponse(user))
                .collect(Collectors.toList());
    }

    @Override
    public UserResponse assignSkillToUser(Long userId, Long skillId) {
        User user = _userRepository.findOneById(userId);
        Skill skill = _skillRepository.findOneById(skillId);

        user.getSkills().add(skill);

        User savedUser = _userRepository.save(user);

        return mapUserToUserResponse(savedUser);

    }

    @Override
    public UserResponse removeSkillFromUser(Long userId, Long skillId) {

        User user = _userRepository.findOneById(userId);
        Skill skill = _skillRepository.findOneById(skillId);

        user.getSkills().remove(skill);
        User savedUser = _userRepository.save(user);

        return mapUserToUserResponse(savedUser);
    }

    @Override
    public List<UserResponse> getUserByName(String name) throws Exception {

        List<User> users =_userRepository.findByName(name);

        if (users == null) {
            throw new Exception(String.format("user with %name name is not found", name));
        }

        return users
                .stream()
                .map(user -> mapUserToUserResponse(user))
                .collect(Collectors.toList());
    }

    UserResponse mapUserToUserResponse(User user) {
        UserResponse userResponse = new UserResponse();

        userResponse.setId(user.getId());
        userResponse.setDateOfBirth(user.getDateOfBirth());
        userResponse.setEmail(user.getEmail());
        userResponse.setName(user.getName());
        userResponse.setNumber(user.getNumber());

        return userResponse;
    }


}
