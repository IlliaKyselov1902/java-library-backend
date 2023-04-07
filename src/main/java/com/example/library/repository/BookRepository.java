package com.example.library.repository;

import com.example.library.model.entity.Book;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
    @Override
    void deleteById(@NotNull Long bookId);
}