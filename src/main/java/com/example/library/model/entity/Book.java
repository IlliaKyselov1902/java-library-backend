package com.example.library.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@Table(name = "tbl_book")
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @NotEmpty
    @Column(name = "book_name", nullable = false, unique = true)
    String bookName;
    @Column(name = "year_of_release")
    int yearOfRelease;
    @Column(name = "publisher")
    String publisher;
    @Column(name = "description")
    String description;

    @Enumerated(EnumType.STRING)
    Genre genre;

    //todo add author add image add path to read
}
