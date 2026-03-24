package com.library.library_system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import com.library.library_system.dao.BookRepository;
import com.library.library_system.dao.CartRepository;
import com.library.library_system.dao.CustomerRepository;
import com.library.library_system.dao.CartItemRepository;
import com.library.library_system.entities.Book;
import com.library.library_system.entities.CartItem;
import com.library.library_system.entities.Cart;
import com.library.library_system.entities.Customer;
import com.library.library_system.entities.CheckedOutStatus;
import java.util.HashSet;
import java.util.Set;

@SpringBootApplication

public class LibrarySystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibrarySystemApplication.class, args);

	}

	@Bean

	CommandLineRunner run(BookRepository bookRepository, CartRepository cartRepository,CustomerRepository customerRepository, CartItemRepository cartItemRepository) {
		return args -> {

			//flow of saving a cart to a customer
			Customer cus = new Customer(); // create customer object
			cus.setFirstName("Enos");//set the first name
			cus.setLastName("Lewis");//set the last name
			cus.setPhoneNumber("7709906496");// set the phone number
			customerRepository.save(cus); //save the customer to the database

// 2. Save cart
			Cart cart1 = new Cart(); //create a cart object
			cart1.setCustomer(cus); // assign the cart to the customer since the cart owns the relationship
			cartRepository.save(cart1); // save the cart to the database

// 3. Save book
			Book book1 = new Book(); // create a book object
			book1.setTitle("Harry Potter"); // set the title for the book
			book1.setAuthor("J.K. Rowling"); // set the author for the book
			book1.setGenre("Fantasy"); // set the genre for the book
			book1.setAvailableCopies(3); // set the copies for the book
			bookRepository.save(book1); // save the book to the database

			Book book2 = new Book(); // create a book object
			book2.setTitle("Necromancer"); // set the title for the book
			book2.setAuthor("Stephen Gobling"); // set the author for the book
			book2.setGenre("Sci-Fi"); // set the genre for the book
			book2.setAvailableCopies(2); // set the copies for the book
			bookRepository.save(book2); // save the book to the database

// 4. Save cart item - set everything FIRST then save
			CartItem cartItem1 = new CartItem(); // create a cart item object
			CartItem cartItem2 = new CartItem();
			cartItem1.setBook(book1);// assign the book to the cart item object
			cartItem2.setBook(book2);
			cartItem1.setCart(cart1); // assign the cart item to the cart
			cartItem2.setCart(cart1);
			cartItem1.setStatus(CheckedOutStatus.CHECKED_OUT); // set the status of the cart item to checked out
			cartItem2.setStatus(CheckedOutStatus.CHECKED_OUT);
			cartItemRepository.save(cartItem1); // save the cart item to the database
			cartItemRepository.save(cartItem2);


		};
	}
}