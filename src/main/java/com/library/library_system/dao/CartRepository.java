package com.library.library_system.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.library.library_system.entities.Cart;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("http://localhost:4201/")


public interface CartRepository extends JpaRepository<Cart, Long> {
}
