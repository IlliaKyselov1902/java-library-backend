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
public class BookController {
    BookService bookService;
    //Rewrite with pagination
    @GetMapping("/books")
    @ResponseStatus(HttpStatus.FOUND)
    List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/books/{book-id}")
    @ResponseStatus(HttpStatus.FOUND)
    Book getBookById(@PathVariable("book-id") Long bookId) {
        return bookService.getBookById(bookId);
    }

    @GetMapping("/books/author/{author-id}")
    @ResponseStatus(HttpStatus.OK)
    List<Book> getBooksByAuthor(@PathVariable("author-id") Long authorId) {
        return bookService.getBooksByAuthor(authorId);
    }

    @PostMapping("/author/{author-id}/add")
    @ResponseStatus(HttpStatus.CREATED)
    Book addBook(@PathVariable("author-id") Long authorId,
                 BookCreationRequest request) {
        return bookService.addBook(request);
    }

    @PatchMapping("/edit/{author-id}/{book-id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    SuccessEditResponse editBook(@PathVariable("author-id") Long authorId,
                                 @PathVariable("book-id") Long bookId,
                                 @RequestBody BookCreationRequest request) {
        return bookService.editBook(bookId, request);
    }

    @DeleteMapping("/author/{author-id}/books/{book-id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    SuccessEditResponse editBook(@PathVariable("author-id") Long authorId,
                                 @PathVariable("book-id") Long bookId) {
        return bookService.deleteBook(bookId);
    }
}
