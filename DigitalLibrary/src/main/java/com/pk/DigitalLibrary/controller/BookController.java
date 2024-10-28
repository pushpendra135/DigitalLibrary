package com.pk.DigitalLibrary.controller;

import com.pk.DigitalLibrary.entity.Book;
import com.pk.DigitalLibrary.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

import static org.aspectj.lang.reflect.DeclareAnnotation.Kind.Type;

@RestController
@RequestMapping("/book")
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping(value = "/add", consumes = "application/json")
    public ResponseEntity<Book> addBook(@RequestBody Book book) {
        Book savedBook = this.bookService.addBook(book);
        return new ResponseEntity<>(savedBook, HttpStatus.CREATED);
    }

    @GetMapping("/list")
    public ResponseEntity<List<Book>> getAllBooks() {
        List<Book> books = this.bookService.getAllBooks();
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    // Getting book using path Parameter
    @GetMapping("/{bookID}")
    public ResponseEntity<Book> getBookById(@PathVariable UUID bookID) {
        Book book = this.bookService.getBookById(bookID);
        return new ResponseEntity<>(book, HttpStatus.OK);
    }
}
