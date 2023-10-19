package com.kabs.bookdb;

import com.kabs.bookdb.entity.Book;
import com.kabs.bookdb.repository.bookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BookmanagerApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(BookmanagerApplication.class, args);
	}

	@Autowired
	private bookRepository bookRepository;

	@Override
	public void run(String... args) {

	}

}
