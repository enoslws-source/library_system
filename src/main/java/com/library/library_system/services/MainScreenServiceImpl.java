package com.library.library_system.services;
import com.library.library_system.dao.BookRepository;

import com.library.library_system.entities.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MainScreenServiceImpl implements MainScreenService {

    private BookRepository bookRepository;

    @Autowired // this is like showing up to work and having your boss hand you the tools necessary to do the job
    // this is contructor injection , instead of creating a book object in the class, spring creates and passes it for me
    public MainScreenServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override // this says i am fulfilling the contract from MAinscreenService inteface. It will also correct if its spelled wrong
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book findById(long id){
        Optional<Book> optionalBook = bookRepository.findById(id); // gets the book from the database based on the id
        Book book = optionalBook.orElse(null); // checks if it is there, if it isn't then returns null
        return book; // returns the book
    }
}

