package com.library.library_system.entities;

import java.util.HashSet;
import java.util.Set;

public class Cart {

    private long id;

    Set<CartItem> cartItem = new HashSet<>();

    Customer customer;

    public Cart(){

    }

    public void setId(long id){
        this.id  = id;
    }
    public long getId(){
        return id;
    }
    public void setCartItem(Set<CartItem> cartItem){
        this.cartItem = cartItem;
    }
    public Set<CartItem> getCartItem(){
        return cartItem;
    }
    public void setCustomer(Customer customer){
        this.customer = customer;
    }
    public Customer getCustomer(){
        return customer;
    }
}
