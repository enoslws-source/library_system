package com.library.library_system.services;

import com.library.library_system.entities.Cart;
import com.library.library_system.entities.Customer;
import com.library.library_system.entities.CartItem;
import com.library.library_system.dao.CartRepository;
import com.library.library_system.dao.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;

//this calls the interface
//assigns cart items to cart,
// assign cart to customer,
// generate order tracking number,
// save everything to the right order
//this class will implement checkoutservice
//should have a method called placeorder  that takes the purchase data as a parameter
//sholud return the order tracking number
@Service

public class CheckoutServiceImpl implements CheckoutService{

    private CustomerRepository customerRepository;
    private CartRepository cartRepository;
    private String orderTrackingNumber;

    public CheckoutServiceImpl placeOrder(PurchaseData purchaseData) { // we are getting the purchase data - customer, cart and the items
        //generate a UUID for the order tracking number
        // convert the OTN to a String
        //assign it as a tracking number to the order

        orderTrackingNumber = UUID.randomUUID().toString();

        //assign the cart items to the cart
        Cart cart = purchaseData.getCart();
        cart.setOrderTrackingNumber(orderTrackingNumber);
        cart.setStatus(ORDERED);

        //assign the cart to the customer
        Customer customer = purchaseData.getCustomer();
        customer.setCart(cart);


        Set<CartItem> cartItems = purchaseData.getCartItem();

        for(<cartItem> : cartItem ){
            cartItems.add(cartItem);
    }
        cartRepository.save(<CartItem>);
    }
}
