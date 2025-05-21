package com.app.OpenLibrary.model;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;


@Data
public class Book {

    @NotNull
    @NotBlank
    private String bookId;
    private String isbn;
    private String title;
    private String author;
    private String publishedTime;
    private boolean status;
}
