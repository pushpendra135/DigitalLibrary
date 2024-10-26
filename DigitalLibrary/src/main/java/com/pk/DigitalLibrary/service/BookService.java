package com.pk.DigitalLibrary.service;

import com.pk.DigitalLibrary.entity.Book;
import com.pk.DigitalLibrary.repository.BookRespository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//Business Logic inside service
@Service
@Slf4j
public class BookService {

    private BookRespository bookRepository;

    @Autowired
    public BookService(BookRespository bookRepository) {

        this.bookRepository = bookRepository;
    }

    public Book addBook(Book book) {
        log.info("Saving a new book");
        Book savedBook = this.bookRepository.save(book);
        log.info("Saved a new book with ID: {}", savedBook.getId());
        return savedBook;
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }
}
