package com.example.bookapi;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class BookService {

@Value("${bookapi.url}")
String url;
//    private final WebClient webClient = WebClient.create("https://my-json-server.typicode.com/Flooooooooooorian/BookApi");
    private final WebClient webClient = WebClient.create();

    public List<Book> getBooks() {
        return webClient
                .get()
                .uri(url + "/books")
                .retrieve()
                .toEntityList(Book.class)
                .block()
                .getBody();
    }

    public Book getBookByID(String id){
        List<Book> bookList = getBooks();
            for (Book book : bookList) {
                if(book.id().equals(id)){
                    return book;
                }
            }
            throw new NoSuchElementException("No book with id " + id + " was found");
        }




}
