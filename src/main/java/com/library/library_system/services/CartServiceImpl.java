package com.library.library_system.services;
import com.library.library_system.dao.BookRepository;
import com.library.library_system.entities.Book;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl implements CartService {

    private BookRepository bookRepository;

    @Autowired
    public CartServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> findAll() {
        return (List<Book>) bookRepository.findAll();
    }

    @Override
    public Book findById(int theId) {
        Long theIdl = (long) theId; // this line is typecasting theId from int to a Long in a new variable called theIdl, Book objects id is a long and not an int
        Optional<Book> result = bookRepository.findById(theIdl); // this is calling the database through JPA and trying to find an id with that Idl which was just typecasted
        //optional means there might be a result and there might not be

        Book book = null; // this is creating a book object to use later, if a book isnt found then it stays equal to null
        if (result.isPresent()) { // isPresent returns only true or false(boolean) if our optional list, returns a value(true)
            book = result.get(); // set the book equal to whatever was found, we dont return anything yet
        } else {
            return null; // we return null because no book was found
        }
        return book; // return the book that was found
    }

    @Override
    public void save(Book theBook){
        bookRepository.save(theBook);
    }

    @Override
    public void deleteById(int theId){
        long theIdl = (long) theId;

         bookRepository.deleteById(theIdl);
    }
}
