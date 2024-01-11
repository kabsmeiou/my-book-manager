package com.kabs.bookdb.service.impl;

import com.kabs.bookdb.entity.Book;
import com.kabs.bookdb.exceptions.DuplicateBookException;
import com.kabs.bookdb.repository.bookRepository;
import com.kabs.bookdb.service.bookService;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
public class bookServiceImpl implements bookService {

    private final bookRepository bookRepository;

    public bookServiceImpl(bookRepository bookRepository) {
        super();
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    public boolean isDuplicate(Book book) {
        return false;
    }

    @Override
    public Book getBookByID(Long id) {
        return bookRepository.findById(id).get();
    }

    @Override
    public Book updateBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public List<Book> getAllBooksSortedByHighestRating() {
        List<Book> books = bookRepository.findAll();
        //sort the list by rating in descending order
        Collections.sort(books, Comparator.comparing(Book::getRating).reversed());
        return books;
    }

    @Override
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }
}
