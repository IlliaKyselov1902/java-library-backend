package com.example.library.service.implementations;

import com.example.library.exception.BookNotFoundException;
import com.example.library.model.entity.Book;
import com.example.library.model.request.BookCreationRequest;
import com.example.library.model.responce.SuccessEditResponse;
import com.example.library.repository.BookRepository;
import com.example.library.service.interfaces.BookService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class BookServiceImpl implements BookService {
    BookRepository bookRepository;

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public List<Book> getBooksByAuthor(Long authorId) {
        return null;
    }

    @Override
    public Book getBookById(Long bookId) {
        return bookRepository.findById(bookId).orElseThrow(BookNotFoundException::new);
    }

    @Override
    public Book addBook(BookCreationRequest request) {
        return null;
    }

    @Override
    public SuccessEditResponse editBook(Long bookId, BookCreationRequest request) {
        return null;
    }

    @Override
    public SuccessEditResponse deleteBook(Long bookId) {

        if (!bookRepository.existsById(bookId)) {
            throw new BookNotFoundException();
        }
        bookRepository.deleteById(bookId);
        return new SuccessEditResponse("Book successfully deleted");
    }
}
