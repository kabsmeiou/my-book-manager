package com.kabs.bookdb.service;

import com.kabs.bookdb.entity.Book;

import java.util.List;

public interface bookService {
    List<Book> getAllBooks();
    Book saveBook(Book book);
    Book getBookByID(Long id);
    Book updateBook(Book book);
    boolean isDuplicate(Book book);
}
