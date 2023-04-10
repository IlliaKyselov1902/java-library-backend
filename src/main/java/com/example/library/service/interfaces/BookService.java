package com.example.library.service.interfaces;

import com.example.library.model.entity.Book;
import com.example.library.model.request.BookCreationRequest;
import com.example.library.model.responce.SuccessEditResponse;

import java.util.List;

public interface BookService {
    List<Book> getAllBooks();
    Book getBookById(Long bookId);
    Book addBook(BookCreationRequest request);
    SuccessEditResponse editBook(long id, BookCreationRequest request);
    SuccessEditResponse deleteBook(Long bookId);
}
