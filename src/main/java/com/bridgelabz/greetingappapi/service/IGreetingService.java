package com.bridgelabz.greetingappapi.service;

import com.bridgelabz.greetingappapi.dto.UserDto;

public interface IGreetingService {
    public UserDto getGreeting(UserDto userDto);
}
