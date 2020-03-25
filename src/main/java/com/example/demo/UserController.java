package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path="/user")
public class UserController {
    @Autowired // This means to get the bean called userRepository
    private UserRepository userRepository; // Which is auto-generated by Spring, we will use it to handle the data
    @Autowired
    private TaskRepository taskRepository;

    @PostMapping // Map ONLY POST Requests
    public @ResponseBody User addNewUser (@RequestParam String name
            , @RequestParam String email) {

        User n = new User();
        n.setName(name);
        n.setEmail(email);
        userRepository.save(n);
        return n;
    }

    @GetMapping(value =  "/{userId}")
    public @ResponseBody User getUserById(@PathVariable Integer userId) {
        Optional<User> userResponse = userRepository.findById(userId);
        User user = userResponse.get();
        return user;
    }

    @GetMapping(value = "/{userId}/task")
    public @ResponseBody List<Task> getTasksByUser(@PathVariable Integer userId) {
        return taskRepository.findByUserId(userId);
    }
}
