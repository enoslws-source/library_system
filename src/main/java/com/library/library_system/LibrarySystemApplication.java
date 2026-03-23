package com.library.library_system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import com.library.library_system.dao.BookRepository;
import com.library.library_system.entities.Book;

@SpringBootApplication

public class LibrarySystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibrarySystemApplication.class, args);

	}

	@Bean

	CommandLineRunner run(BookRepository bookRepository) {
		return args -> {

			Book book1 = new Book();

			book1.setTitle("Harry Potter");
			book1.setAuthor("J.K. Rowling");
			book1.setGenre("Fantasy");
			book1.setAvailableCopies(3);

			bookRepository.save(book1);
		};
	}
}