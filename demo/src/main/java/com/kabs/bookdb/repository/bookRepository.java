package com.kabs.bookdb.repository;

import com.kabs.bookdb.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface bookRepository extends JpaRepository<Book, Long> {

}
