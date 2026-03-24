package com.library.library_system.entities;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;

@Entity

public class Customer{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id")
    private long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "phone_number")
    private String phoneNumber;

    @OneToOne(mappedBy = "customer") // customer is the parent in this relationship, it says look at what the child called me. The child in this relationship is class cart
    private Cart cart;


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
    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }
    public String getPhoneNumber(){
        return phoneNumber;
    }
    public void setCart(Cart cart){
        this.cart = cart;
    }
    public Cart getCart(){
        return cart;
    }
}