package com.arsad.libarymangaement.Repo;

import com.arsad.libarymangaement.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepo extends JpaRepository<User,Integer> {
    List<User> findByName(String name);
}
