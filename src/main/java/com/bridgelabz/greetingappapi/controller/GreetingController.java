package com.bridgelabz.greetingappapi.controller;

import com.bridgelabz.greetingappapi.dto.GreetingDto;
import com.bridgelabz.greetingappapi.dto.UserDto;
import com.bridgelabz.greetingappapi.service.GreetingServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/greetingapp")
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @Autowired
    GreetingServiceImpl service;

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
    public GreetingDto greetingPost(@RequestBody UserDto userdto) {
        return new GreetingDto(counter.incrementAndGet(), String.format(template, userdto.getFirstName() + " " + userdto.getLastName()));
    }

    @PutMapping("/put/{firstName}")
    public GreetingDto greetingPut(@PathVariable String firstName, @RequestParam(value = "lastName") String lastName) {
        return new GreetingDto(counter.incrementAndGet(), String.format(template, firstName + " " + lastName));
    }

    @PostMapping("/message")
    public UserDto getMessage(@RequestBody UserDto userDto){
        return service.getGreeting(userDto);
    }
}
