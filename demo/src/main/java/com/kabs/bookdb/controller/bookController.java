package com.kabs.bookdb.controller;


import com.kabs.bookdb.entity.Book;
import com.kabs.bookdb.exceptions.DuplicateBookException;
import com.kabs.bookdb.service.bookService;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.sql.SQLIntegrityConstraintViolationException;

@Controller
public class bookController {
    private final bookService bookService;

    public bookController(bookService bookService) {
        super();
        this.bookService = bookService;
    }

    @GetMapping("/books") //main page
    public String listBooks(Model model) {
        model.addAttribute("books", bookService.getAllBooks());
        return "books";
    }

    @GetMapping("/books/new") //book creation form
    public String createBookForm(Model model) {
        Book book = new Book();
        model.addAttribute("book", book);
        return "create_book";
    }

    @PostMapping("/books") //redirecting after adding
    public String saveBook(@ModelAttribute("book") Book book, Model model) {
        try {
            bookService.saveBook(book);
        } catch (DataIntegrityViolationException err) {
            //handle the exception
            model.addAttribute("errorMessage", "A book with the same title and author already exists.");
            return "create_book"; //return to the create_book form and display necessary info
        }
        return "redirect:/books";
    }
}
