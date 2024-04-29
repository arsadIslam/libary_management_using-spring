package com.arsad.libarymangaement.Controller;

import com.arsad.libarymangaement.Service.BookService;
import com.arsad.libarymangaement.Entity.Books;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/book")
public class Bookcontroller {
    @Autowired
    private BookService bookService;
    @GetMapping
    public List<Books> getAllbooks(){
        return bookService.findAll();
    }
    @GetMapping("/{id}")
    public Books getBooks(@PathVariable int id){
        return bookService.findById(id);
    }
    @GetMapping("/{title}")
    public List<Books> findByTitle(@PathVariable String title){
        return bookService.findByTitle(title);
    }
    @PostMapping
    public Books addBook(@RequestBody Books books){
        return bookService.save(books);
    }
    @PutMapping
    public Books updateBook(@PathVariable int id,@RequestBody Books books){
        return bookService.save(books);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable int id){
        bookService.deleteById(id);
    }

    @PostMapping("/{bookId}/return")
    public ResponseEntity<Books> returnBook(@PathVariable int bookId) {
        Books returnedBook = bookService.returnBook(bookId);
        if (returnedBook != null) {
            return ResponseEntity.ok(returnedBook);
        } else {
            return ResponseEntity.badRequest().build(); // or a more descriptive error response
        }
    }

    @PostMapping("/{bookId}/borrow/{userId}")
    public ResponseEntity<Books> borrowBook(@PathVariable int bookId, @PathVariable int userId) {
        Books borrowedBook = bookService.borrowBook(bookId, userId);
        if (borrowedBook != null) {
            return ResponseEntity.ok(borrowedBook);
        } else {
            return ResponseEntity.badRequest().build(); // or a more descriptive error response
        }
    }
}
