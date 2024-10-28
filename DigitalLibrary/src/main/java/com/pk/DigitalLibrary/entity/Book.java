package com.pk.DigitalLibrary.entity;

import com.pk.DigitalLibrary.enums.Category;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@With
public class Book {

    @Id
    private UUID id = UUID.randomUUID();

    private String name;

    private String author;

    @Column(unique = true)
    private String isbn;

    private Double price;

    private String description;


    public Category category;

}


