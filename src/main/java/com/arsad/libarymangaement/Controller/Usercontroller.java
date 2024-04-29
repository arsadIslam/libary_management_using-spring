package com.arsad.libarymangaement.Controller;

import com.arsad.libarymangaement.Entity.User;
import com.arsad.libarymangaement.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class Usercontroller {
    @Autowired
    private UserService userService;

    @GetMapping
    public List<User>  getAllUser(){
        return userService.findAll();
    }
    @GetMapping("/{id}")
    public User findUser(@PathVariable int id){
        return userService.findByid(id);
    }
    @GetMapping("/{name}")
    public List<User> getUser(@PathVariable String name){
        return userService.findByName(name);
    }

    @PostMapping

    public User addUser(@RequestBody User user){
        return userService.save(user);
    }


}
