package com.kabs.bookdb.controller;


import com.kabs.bookdb.entity.Book;
import com.kabs.bookdb.exceptions.DuplicateBookException;
import com.kabs.bookdb.service.bookService;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

@Controller
public class bookController {
    private final bookService bookService;

    public bookController(bookService bookService) {
        super();
        this.bookService = bookService;
    }

    @GetMapping("/books") //main page
    public String listBooks(Model model) {
        model.addAttribute("books", bookService.getAllBooksSortedByHighestRating());
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
        List<Book> currentBooks = bookService.getAllBooks();
        for (Book elem : currentBooks) {
            if (elem.getTitle().equalsIgnoreCase(book.getTitle()) && elem.getAuthor().equalsIgnoreCase(book.getAuthor())) {
                model.addAttribute("errorMessage", "A book with the same title and author already exists.");
                return "create_book"; //return to the create_book form and display necessary info
            }
        }
        bookService.saveBook(book);
        return "redirect:/books";
    }

    @GetMapping("/books/edit/{id}")
    public String updateBookForm(@PathVariable Long id, Model model) {
        model.addAttribute("book", bookService.getBookByID(id));
        return "update_book";
    }

    @PostMapping("/books/{id}")
    public String updateBook (@PathVariable Long id, @ModelAttribute("book") Book book, Model model) {
        Book existingBook = bookService.getBookByID(id);
        existingBook.setId(id);
        existingBook.setAuthor(book.getAuthor());
        existingBook.setReview(book.getReview());
        existingBook.setRating(book.getRating());
        existingBook.setTitle(book.getTitle());
        bookService.updateBook(existingBook);
        return "redirect:/books";
    }
}
