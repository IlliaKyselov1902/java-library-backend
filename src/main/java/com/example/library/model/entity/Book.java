package com.example.library.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.validator.constraints.URL;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
    @Column(name = "book_name", nullable = false, unique = true)
    private String bookName;
    @Column(name = "year_of_release")
    private Integer yearOfRelease;
    @Column(name = "publisher")
    private String publisher;
    @Column(name = "description")
    private String description;
    @Enumerated(EnumType.STRING)
    private Genre genre;
    @URL
    String image;
    @URL
    @Column(name = "book_file")
    String bookFile;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "author_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Author author;
}
