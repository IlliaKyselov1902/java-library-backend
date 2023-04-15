package com.example.library.service.interfaces;

import com.example.library.model.entity.Book;
import com.example.library.model.request.BookCreationRequest;
import com.example.library.model.responce.SuccessEditResponse;

import java.util.List;

public interface BookService {
    List<Book> getAllBooks();
    List<Book> getBooksByAuthor(Long authorId);
    Book getBookById(Long bookId);
    Book addBook(BookCreationRequest request);
    SuccessEditResponse editBook(Long bookId, BookCreationRequest request);
    SuccessEditResponse deleteBook(Long bookId);


}
