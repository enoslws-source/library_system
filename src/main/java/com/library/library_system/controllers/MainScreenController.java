package com.library.library_system.controllers;
// in the service class, we want to inject the database repository then we can use the jpa methods to manipulate the data


import com.library.library_system.entities.Book;
import com.library.library_system.services.MainScreenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mainscreen")
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:4201"})

public class MainScreenController {

    // gets the http request to display all the books

    @Autowired
    private MainScreenService mainScreenService; // spring looks for all the classes that implements mainscreen service
    //we then have acess to all those methods through loose coupling


    @GetMapping
    public List<Book> getAllBooks(){ // we are returning a list of all the books from the database to angular
        return mainScreenService.findAll();
    }

    @GetMapping("/{id}")
    public Book getBook(@PathVariable("id") long id){
        return mainScreenService.findById(id);
    }
}
