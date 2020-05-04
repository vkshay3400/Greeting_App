package com.bridgelabz.greetingapp.controller;

import com.bridgelabz.greetingapp.dto.Greeting;
import com.bridgelabz.greetingapp.dto.Userdto;
import com.bridgelabz.greetingapp.service.IGreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/greetingapp")
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    @Autowired
    IGreetingService service;

    @GetMapping("/greetings")
    public Greeting greeting(long l, @RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }

    @RequestMapping(value = {"/query"}, method = RequestMethod.GET)
    public Greeting greetingWithDefault(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }

    @GetMapping("/param/{name}")
    public Greeting greetingWithParam(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }

    @PostMapping("/post")
    public Greeting greetingPost(@RequestBody Userdto userdto) {
        return new Greeting(counter.incrementAndGet(), String.format(template, userdto.getFirstName() + " " + userdto.getLastName()));
    }

    @PutMapping("/put/{firstName}")
    public Greeting greetingPut(@PathVariable String firstName, @RequestParam(value = "lastName") String lastName) {
        return new Greeting(counter.incrementAndGet(), String.format(template, firstName + " " + lastName));
    }

    @RequestMapping("/message")
    public String getMessage(){
        return service.getGreeting();
    }
}
