package com.library.library_system.controllers;

import com.library.library_system.services.CheckoutService;
import com.library.library_system.services.PurchaseData;
import com.library.library_system.services.PurchaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/checkout")
@CrossOrigin("http://localhost:4201/")
public class CheckoutController {


    //receives http request
@Autowired
   private CheckoutService checkoutService;

    //returns to http

    @PostMapping("/placeOrder")
    public PurchaseResponse placeOrder(@RequestBody PurchaseData purchaseData){//angular sends JSON and Requestbody is letting Spring know to convert it to a purchaseData object

        return checkoutService.placeOrder(purchaseData);
    }

}
