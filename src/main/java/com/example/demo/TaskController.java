package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path="/task")

public class TaskController {
    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private UserRepository userRepository;

    @PostMapping
    public @ResponseBody Task add(@RequestParam Integer userId, @RequestParam String description) throws Exception {
        Optional<User> byId = userRepository.findById(userId);
        if(!byId.isPresent()) {
            throw new Exception("No such user exists!");
        }
        Task t = new Task();
        t.setDescription(description);
        t.setUser(byId.get());
        taskRepository.save(t);

        return t;
    }
}
