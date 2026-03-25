package com.library.library_system.services;
import com.library.library_system.entities.Book;
import java.util.List;

//returns the order tracking number to angular
//sets the ordertracking number
//gets the order tracking number
public class PurchaseResponse {

    private String orderTrackingNumber;

    public PurchaseResponse(){
    }

    public void setOrderTrackingNumber(String orderTrackingNumber){
        this.orderTrackingNumber = orderTrackingNumber;
    }
    public String getOrderTrackingNumber(){
        return orderTrackingNumber;
    }
}
