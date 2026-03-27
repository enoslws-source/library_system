package com.library.library_system.services;

import com.library.library_system.entities.*;
import com.library.library_system.dao.CartRepository;
import com.library.library_system.dao.CustomerRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;
import java.util.HashSet;

//this calls the interface
//assigns cart items to cart,
// assign cart to customer,
// generate order tracking number,
// save everything to the right order
//this class will implement checkoutservice
//should have a method called placeorder  that takes the purchase data as a parameter
//sholud return the order tracking number
@Service

public class CheckoutServiceImpl implements CheckoutService { // this is the class

    @Autowired // this enables Spring to bring you whatever object, in this case it creates the customerRepo object
    private CustomerRepository customerRepository;

    @Autowired // this enables Spring to bring you whatever object, in this case it creates teh cartREpository object
    private CartRepository cartRepository;

    @Transactional // either everything works, or nothing works. Everything in this method has to work for the data to be saved to the database
    //if not, the exectution is canceled and is rolled back like nothing ever happened. it keeps the data clean
    @Override // this means i am fulfilling the contract from the interface checkoutService
    public PurchaseResponse placeOrder(PurchaseData purchaseData) { // we are getting the purchase data - customer, cart and the items
        //generate a UUID for the order tracking number
        // convert the OTN to a String
        //assign it as a tracking number to the order

        String orderTrackingNumber = UUID.randomUUID().toString(); // instatiates a random number and assigns it to order tracking number


        //assign the cart to the customer
        Customer customer = purchaseData.getCustomer(); // creates a customer object
        customerRepository.save(customer); // saves the customer to database

        //assign the cart items to the cart
        Cart cart = purchaseData.getCart(); // gets the data from the front end purchase data and assigns it to cart object
        cart.setOrderTrackingNumber(orderTrackingNumber); // sets the tracking number to the cart
        cart.setStatus(Status.ORDERED); // changes the status of the cart to ordered
        cart.setCustomer(customer); // sets the cart to the customer object. The cart owns the relationship


        Set<CartItem> cartItems = purchaseData.getCartItems();

        for (CartItem item : cartItems) { // this is creating a temp variable to store objects in this for each loop
            item.setCart(cart); // this is setting each item pulled from purchase data to the cart in the hashset
            item.setStatus(CheckedOutStatus.CHECKED_OUT);
        }

        cartRepository.save(cart);// saves all the extracted data from the for each loop into the cart database

        return new PurchaseResponse(orderTrackingNumber);

    }

}


