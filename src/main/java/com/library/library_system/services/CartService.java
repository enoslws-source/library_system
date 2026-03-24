package com.library.library_system.services;
import com.library.library_system.entities.Book;
import java.util.List;


public interface CartService {

    public List<Book> findAll();
            public Book findById(int theId);
    public void save(Book theBook);
    public void deleteById(int theId);
}
