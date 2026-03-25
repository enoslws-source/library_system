package com.library.library_system.entities;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;

@Entity

public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id")
    private long id;

    @OneToMany(mappedBy = "cart") // cart is the parent in the cart item relationship
    Set<CartItem> cartItem = new HashSet<>();

    @OneToOne
    @JoinColumn(name = "customer_id")
    Customer customer;

    @Column(name = "order_tracking_number")
    String orderTrackingNumber;

    @Column(name = "status")
    Status status;

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
    public void setOrderTrackingNumber(String orderTrackingNumber){
        this.orderTrackingNumber = orderTrackingNumber;
    }
    public String getOrderTrackingNumber(){
        return orderTrackingNumber;
    }
    public void setStatus(Status status){
        this.status = status;
    }
    public Status getStatus(){
        return status;
    }
}
