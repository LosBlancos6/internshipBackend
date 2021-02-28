package com.intens.proj.controller;

import com.intens.proj.dto.request.CreateUserRequest;
import com.intens.proj.dto.request.CreateUserSkillRequest;
import com.intens.proj.dto.response.UserResponse;
import com.intens.proj.service.IUserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final IUserService _userService;

    public UserController(IUserService userService) {
        _userService = userService;
    }

    @PostMapping
    public UserResponse createUser(@RequestBody CreateUserRequest request) {
        try {
            return  _userService.createUser(request);
        } catch (Exception ex) {
            return null;
        }
    }

    @GetMapping("/{id}")
    public UserResponse getUser(@PathVariable Long id) {
        try {
            return _userService.getUser(id);
        } catch (Exception ex) {
            return null;
        }
    }

    @GetMapping
    public List<UserResponse> getAllUsers() {
        try {
            return _userService.getAllUsers();
        } catch (Exception ex) {
            return null;
        }
    }

    @PutMapping("/{id}")
    public UserResponse updateUser(@PathVariable Long id, @RequestBody CreateUserRequest request ) {
        try {
           return  _userService.updateUser(id,request);
        } catch (Exception ex) {
            return null;
        }
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) throws Exception {
        _userService.deleteUser(id);
    }

    @PostMapping("/skill")
    public UserResponse assignSkillToUser(@RequestBody CreateUserSkillRequest request) throws Exception {
        try {
            return _userService.assignSkillToUser(request.getUserId(), request.getSkillId());
        } catch (Exception ex) {
            return null;
        }
    }

    @PostMapping("/removeSkill")
    public UserResponse removeSkillFromUser(@RequestBody CreateUserSkillRequest request) {
        try {
            return _userService.removeSkillFromUser(request.getUserId(), request.getSkillId());
        } catch (Exception ex) {
            return null;
        }
    }

    @GetMapping("bySkill/{name}")
    public List<UserResponse> getAllUsersBySkill(@PathVariable String name) {
        try {
            return _userService.getAllUsersBySkill(name);
        }catch (Exception ex) {
            return null;
        }
    }

    @GetMapping("/byName/{name}")
    public List<UserResponse> getUserByName(@PathVariable String name) {
        try {
            return _userService.getUserByName(name);
        } catch (Exception ex) {
            return null;
        }
    }

}
