package com.example.library.controller;

import com.example.library.model.entity.Book;
import com.example.library.model.request.BookCreationRequest;
import com.example.library.model.responce.SuccessEditResponse;
import com.example.library.service.interfaces.BookService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/books")
public class BookController {
    BookService bookService;
    //Rewrite with pagination
    @GetMapping("/get")
    @ResponseStatus(HttpStatus.FOUND)
    List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/get/{book-id}")
    @ResponseStatus(HttpStatus.FOUND)
    Book getBookById(@PathVariable("book-id") long bookId) {
        return bookService.getBookById(bookId);
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    Book addBook(BookCreationRequest request) {
        return bookService.addBook(request);
    }

    @PatchMapping("/edit/{book-id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    SuccessEditResponse editBook(@PathVariable("book-id") long bookId, @RequestBody BookCreationRequest request) {
        return bookService.editBook(bookId, request);
    }

    @DeleteMapping("/delete/{book-id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    SuccessEditResponse deleteBook(@PathVariable("book-id") Long bookId) {
        return bookService.deleteBook(bookId);
    }
}
