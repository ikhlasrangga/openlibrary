package com.app.OpenLibrary.controller;

import com.app.OpenLibrary.model.Book;
import com.app.OpenLibrary.model.Response;
import com.app.OpenLibrary.service.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value={"/openlibrary/v1/book"})
public class BookController {


    @Autowired
    BookService bookService;



    @PostMapping("/insert")
    public ResponseEntity<Response> insert(@Valid  @RequestBody Book book){
        Response response = new Response();

        response = bookService.insertBookData(book);

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PostMapping("/update")
    public ResponseEntity<Response> update(@Valid @RequestBody Book book){
        Response response = new Response();

        response = bookService.updateBookData(book);

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping
    public ResponseEntity<Response> getAll(){
        Response response = new Response();

        response = bookService.getAllBookData();

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/{author}")
    public ResponseEntity<Response> getDataByAuthor(@PathVariable String author){
        Response response = new Response();

        response = bookService.getBookDataByAuthor(author);

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
