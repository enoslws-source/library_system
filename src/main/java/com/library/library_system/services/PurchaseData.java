package com.library.library_system.services;
import com.library.library_system.entities.Customer;
import com.library.library_system.entities.Cart;
import com.library.library_system.entities.CartItem;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//this is a wrapper or container, its called composition because
// it containseverythingn needed to bundle a purchase order into one object
// getters and setters for customer, cart and cart items;
// book isnt needed here since books are already inside cartitems
@Service
public class PurchaseData {

    private Customer customer;
    private Cart cart;
    private CartItem cartItem;



    public PurchaseData(){

    }

    public void setCustomer(Customer customer){
        this.customer = customer;
    }
    public Customer getCustomer(){
        return customer;
    }
    public void setCart(Cart cart){
        this.cart = cart;
    }
    public Cart getCart(){
        return cart;
    }
    public void setCartItem(CartItem cartItem){
    this.cartItem = cartItem;
    }
    public CartItem getCartItem(){
        return cartItem;
    }
}
