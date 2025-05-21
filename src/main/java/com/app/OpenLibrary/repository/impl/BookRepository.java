package com.app.OpenLibrary.repository.impl;

import com.app.OpenLibrary.model.Book;
import com.app.OpenLibrary.repository.BookInterface;
import com.app.OpenLibrary.util.BookStatement;
import com.app.OpenLibrary.util.InsertUpdateStetment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Repository
public class BookRepository implements BookInterface {


    @Autowired
    NamedParameterJdbcTemplate jdbcTemplate;


    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");



    @Override
    public String insertBookData(Book book) throws ParseException {
       final String sql = "INSERT INTO public.books (book_id, isbn, title, author, published_time) VALUES(:bookId,:isbn,:title,:author,:publishedTime)";

       String bookId = book.getBookId();
       String isbn = book.getIsbn();
       String title = book.getTitle();
       String author = book.getAuthor();
       Date publishedTime = formatter.parse(book.getPublishedTime());

       SqlParameterSource param = new MapSqlParameterSource()
               .addValue("bookId",bookId)
               .addValue("isbn",isbn)
               .addValue("title",title)
               .addValue("author",author)
               .addValue("publishedTime",publishedTime);

       return jdbcTemplate.execute(sql,param, new InsertUpdateStetment());
    }

    @Override
    public String updateBookData(Book book) throws ParseException {
        final String sql = "UPDATE public.books SET isbn=:isbn, title=:title, author=:author, published_time=:publishedTime,modified_time=now() WHERE book_id=:bookId";

        String bookId = book.getBookId();
        String isbn = book.getIsbn();
        String title = book.getTitle();
        String author = book.getAuthor();
        Date publishedTime = formatter.parse(book.getPublishedTime());

        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("bookId",bookId)
                .addValue("isbn",isbn)
                .addValue("title",title)
                .addValue("author",author)
                .addValue("publishedTime",publishedTime);

        return jdbcTemplate.execute(sql,param, new InsertUpdateStetment());
    }

    @Override
    public List<Book> getAllBook() {
        final String sql = "SELECT*FROM PUBLIC.BOOKS";
        return jdbcTemplate.query(sql,new BookStatement());
    }

    @Override
    public List<Book> getBookByAuthor(String Author) {
        final String sql = "SELECT*FROM PUBLIC.BOOKS WHERE AUTHOR =:author";
        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("author",Author);
        return jdbcTemplate.query(sql,param,new BookStatement());
    }
}
