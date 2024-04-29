package com.arsad.libarymangaement.Service;

import com.arsad.libarymangaement.Entity.Books;
import com.arsad.libarymangaement.Entity.User;
import com.arsad.libarymangaement.Repo.BookRepo;
import com.arsad.libarymangaement.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BookService {

    @Autowired
    private BookRepo bookRepo;

    @Autowired
    private UserRepo userRepo;

    public List<Books> findAll() {
        return bookRepo.findAll();
    }

    public Books findById(int id) {
        return bookRepo.findById(id).orElse(null);
    }

    public Books save(Books book) {
        return bookRepo.save(book);
    }

    public void deleteById(int id) {
        bookRepo.deleteById(id);
    }
    public List<Books> findByTitle(String title){
        return bookRepo.findByTitle(title);
    }

    public Books borrowBook(int bookId, int userId) {
        Books books = findById(bookId);
        User user = userRepo.findById(userId).orElse(null);

        if (books != null && !books.isBorrowed() && user != null) {
            books.setBorrowedBy(user);
            books.setBorrowed(true);
            return save(books);
        }

        return null;
    }

    public Books returnBook(int bookId) {
        Books books = findById(bookId);
        if (books != null && books.isBorrowed()) {
            books.setBorrowedBy(null);
            books.setBorrowed(false);
            return save(books);
        }
        return null;
    }
}