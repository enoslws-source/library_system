package com.library.library_system.entities;

import java.util.HashSet;
import java.util.Set;

public class Customer{

    private long id;

    private String firstName;

    private String lastName;

    private long phoneNumber;

    private Set<Cart> cart = new HashSet<>();


    public Customer (){

    }

    public void setId(long id){
        this.id = id;
    }
    public long getId(){
        return id;
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    public String getFirstName(){
        return firstName;
    }
    public void setLastName(String lastName){
        this.lastName = lastName;
    }
    public String getLastName(){
        return lastName;
    }
    public void setPhoneNumber(long phoneNumber){
        this.phoneNumber = phoneNumber;
    }
    public long getPhoneNumber(){
        return phoneNumber;
    }
    public void setCart(Set<Cart> cart){
        this.cart = cart;
    }
    public Set<Cart> getCart(){
        return cart;
    }
}