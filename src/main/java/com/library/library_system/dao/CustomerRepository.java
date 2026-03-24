package com.library.library_system.dao;
import com.library.library_system.entities.Book;
import com.library.library_system.entities.Customer;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.data.jpa.repository.JpaRepository;



@CrossOrigin("http://localhost:4200/")

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
