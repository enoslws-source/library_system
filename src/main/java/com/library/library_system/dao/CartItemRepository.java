package com.library.library_system.dao;
import com.library.library_system.entities.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("http://localhost:4201")
public interface CartItemRepository extends JpaRepository<CartItem, Long> {
}
