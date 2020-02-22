package com.nrc7.mynews.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Book implements Serializable {

    private String name, author;

    public Book() {
    }

    public Book(String name, String author) {
        this.name = name;
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public List<Book> getAllBooks() {
        List<Book> books = new ArrayList<>();
        books.add(new Book("harry potter", "jk rowling"));
        books.add(new Book("lord of the rings", "tolkin"));
        books.add(new Book("the hobbit", "tolkin"));
        books.add(new Book("tengo miedo torero", "lemebel"));
        books.add(new Book("harry potter 2", "jk rowling"));
        books.add(new Book("harry potter 3", "jk rowling"));
        books.add(new Book("harry potter 4", "jk rowling"));
        books.add(new Book("harry potter 5", "jk rowling"));
        books.add(new Book("harry potter 6", "jk rowling"));
        books.add(new Book("harry potter 7", "jk rowling"));

        return books;
    }
}
