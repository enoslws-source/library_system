package com.library.library_system.services;
import com.library.library_system.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

//the menu for what the checkout service can do

public interface CheckoutService {

    PurchaseResponse placeOrder(PurchaseData purchaseData); // this is a method called purchaseData that is returning purchaseData back to Angular


}
