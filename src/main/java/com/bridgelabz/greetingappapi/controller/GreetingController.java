package com.bridgelabz.greetingappapi.controller;

import com.bridgelabz.greetingappapi.dto.GreetingDto;
import com.bridgelabz.greetingappapi.dto.UserDto;
import com.bridgelabz.greetingappapi.model.User;
import com.bridgelabz.greetingappapi.service.IGreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/greetingapp")
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @Autowired
    IGreetingService service;

    @GetMapping("/greetings")
    public GreetingDto greeting(@RequestParam(value = "name", defaultValue = "world") String name) {
        return new GreetingDto(counter.incrementAndGet(), String.format(template, name));
    }

    @RequestMapping(value = {"", "/", "/message"})
    public String show() {
        return "Hello";
    }

    @RequestMapping(value = {"/query"}, method = RequestMethod.GET)
    public GreetingDto greetingWithDefault(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new GreetingDto(counter.incrementAndGet(), String.format(template, name));
    }

    @PostMapping("/post")
    public UserDto greetingPost(@RequestBody UserDto userdto) {
        return service.getGreeting(userdto);
    }

    @GetMapping("/getId/{id}")
    public Object getGreetingByUserId(@PathVariable(value = "id") Long id) {
        return service.getUserById(id);
    }

    @GetMapping("/getList/list")
    public List<User> getUserListData() {
        return service.getUserList();
    }

    @PutMapping("/putId/{id}")
    public User getUpdateUser(@PathVariable(value = "id") Long id) {
        return service.getUserUpdate(id);
    }

    @DeleteMapping("/deleteId/{id}")
    public List<User> getDeleteUser(@PathVariable(value = "id") Long id) {
        return service.getDeleteUser(id);
    }
}
