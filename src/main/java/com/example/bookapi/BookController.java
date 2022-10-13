package com.example.bookapi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BookController {
    BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    // in postman - http://localhost:8080/api/
    @GetMapping
    public List<Book> getAllBooks(){
        return bookService.getBooks();
    }

    // in postman - http://localhost:8080/api/books/978-3-8362-8745-6
    @GetMapping(path = "/books/{id}")
    public Book getBookById(@PathVariable String id){
        return bookService.getBookByID(id);
    }
}
