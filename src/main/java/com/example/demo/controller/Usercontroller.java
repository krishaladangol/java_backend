//package com.example.demo.controller;

package com.example.demo.controller;


import com.example.demo.Service.UserService;
import com.example.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class Usercontroller {
    @Autowired
    private UserService userService;

    @GetMapping("/list")
    public List<User> getAllUser() {
        return userService.getAll();
    }

    @PostMapping("/add")
    public User addUser(@RequestBody User user) {
        return userService.add(user);
        //User addedUser = userService.add(user);
        // return ResponseEntity.status(HttpStatus.CREATED).body(addedUser); // Explicitly return 201 Created
    }
    @PutMapping ("/update/{id}")
    public User updateUser(@RequestBody User user,@PathVariable int id){
        return userService.updateUser(user,id);
    }
    @GetMapping("/get/{id}")
    public User getById(@PathVariable int id){
        return userService.getById(id);
    }
    @DeleteMapping("/delete/{id}")
    public Map<String,Boolean>deleteById(@PathVariable int id) {
        userService.deleteById(id);
        return Map.of("Success",true);

    }

}