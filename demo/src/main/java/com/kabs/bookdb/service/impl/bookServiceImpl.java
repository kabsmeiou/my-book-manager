package com.kabs.bookdb.service.impl;

import com.kabs.bookdb.entity.Book;
import com.kabs.bookdb.exceptions.DuplicateBookException;
import com.kabs.bookdb.repository.bookRepository;
import com.kabs.bookdb.service.bookService;
import org.springframework.stereotype.Service;

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
}
