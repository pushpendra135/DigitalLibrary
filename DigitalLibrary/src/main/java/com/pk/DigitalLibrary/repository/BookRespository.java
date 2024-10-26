package com.pk.DigitalLibrary.repository;

import com.pk.DigitalLibrary.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface BookRespository extends JpaRepository<Book, UUID> {

}
