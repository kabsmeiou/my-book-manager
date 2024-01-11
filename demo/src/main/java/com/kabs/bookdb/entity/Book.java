package com.kabs.bookdb.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "books", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"book_title"})
})
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "book_title", nullable = false)
    private String title;

    @Column(name = "author_name")
    private String author;

    @Column(name = "book_rating")
    private double rating;

    @Column(name = "book_review")
    private String review;

    public Book() {

    }

    public Book(String title, String author, double rating) {
        this.title = title;
        this.author = author;
        this.rating = rating;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getRating() {
        return this.rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }
}
