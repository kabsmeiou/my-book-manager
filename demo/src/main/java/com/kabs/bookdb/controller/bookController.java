package com.kabs.bookdb.controller;


import com.kabs.bookdb.service.bookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class bookController {
    private final bookService bookService;

    public bookController(bookService bookService) {
        super();
        this.bookService = bookService;
    }

    @GetMapping("/books")
    public String listBooks(Model model) {
        model.addAttribute("books", bookService.getAllBooks());
        return "books";
    }
}
