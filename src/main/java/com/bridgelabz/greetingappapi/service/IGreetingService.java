package com.bridgelabz.greetingappapi.service;

import com.bridgelabz.greetingappapi.dto.UserDto;
import com.bridgelabz.greetingappapi.model.User;

import java.util.List;

public interface IGreetingService {
    public UserDto getGreeting(UserDto userDto);

    public Object getUserById(Long userDto);

    public List<User> getUserList();

    public User getUserUpdate(Long id);

    public List<User> getDeleteUser(Long id);
}
