package com.arsad.libarymangaement.Service;

import com.arsad.libarymangaement.Entity.User;
import com.arsad.libarymangaement.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;
    public List<User> findAll(){
        return userRepo.findAll();

    }
    public List<User> findByName(String name){
        return userRepo.findByName(name);
    }
    public User findByid(int id){
        return userRepo.findById(id).orElse(null);
    }
    public User save(User user){
        return userRepo.save(user);
    }

}
