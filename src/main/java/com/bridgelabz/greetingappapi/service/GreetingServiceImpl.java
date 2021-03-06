package com.bridgelabz.greetingappapi.service;

import com.bridgelabz.greetingappapi.dto.UserDto;
import com.bridgelabz.greetingappapi.model.User;
import com.bridgelabz.greetingappapi.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GreetingServiceImpl implements IGreetingService {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    UserRepository userRepository;
    String template = "Hello World %s";

    @Override
    public UserDto getGreeting(UserDto userDto) {
        userDto.setGreeting(String.format(template, userDto.getFirstName()));
        User user = modelMapper.map(userDto, User.class);
        userRepository.save(user);
        return userDto;
    }

    @Override
    public Object getUserById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public List<User> getUserList() {
        return userRepository.findAll();
    }

    @Override
    public User getUserUpdate(Long id) {
        User user = userRepository.findById(id).get();
        user.setGreeting("Updated");
        return userRepository.save(user);
    }

    @Override
    public List<User> getDeleteUser(Long id) {
        userRepository.deleteById(id);
        return userRepository.findAll();
    }
}
