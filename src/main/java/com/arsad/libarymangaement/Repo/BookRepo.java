package com.arsad.libarymangaement.Repo;

import com.arsad.libarymangaement.Entity.Books;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.print.Book;
import java.util.List;

public interface BookRepo extends JpaRepository<Books, Integer> {
    List<Books>findByTitle(String title);

}
