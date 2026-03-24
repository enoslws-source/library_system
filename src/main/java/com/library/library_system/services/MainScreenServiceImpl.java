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

    @Autowired
    public MainScreenServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> findAll() {
        return (List<Book>) bookRepository.findAll();
    }

}

