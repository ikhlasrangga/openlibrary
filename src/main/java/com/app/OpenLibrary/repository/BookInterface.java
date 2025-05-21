package com.app.OpenLibrary.repository;

import com.app.OpenLibrary.model.Book;
import com.app.OpenLibrary.model.Response;

import java.text.ParseException;
import java.util.List;

public interface BookInterface {

    String insertBookData(Book book) throws ParseException;

    String updateBookData(Book book) throws ParseException;
    List<Book> getAllBook();
    List<Book> getBookByAuthor(String Author);

}
