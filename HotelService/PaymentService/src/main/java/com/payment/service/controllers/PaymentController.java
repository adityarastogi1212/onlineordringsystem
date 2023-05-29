package com.payment.service.controllers;

import com.payment.service.entites.Payment;
import com.payment.service.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    //create

    @PostMapping
    public ResponseEntity<Payment> createPayment(@RequestBody Payment payment) {
        return ResponseEntity.status(HttpStatus.CREATED).body(paymentService.create(payment));
    }


    //get single
    @GetMapping("/{paymentId}")
    public ResponseEntity<Payment> createpayment(@PathVariable String paymentId) {
        return ResponseEntity.status(HttpStatus.OK).body(paymentService.get(paymentId));
    }


    //get all
    @GetMapping
    public ResponseEntity<List<Payment>> getAll(){
        return ResponseEntity.ok(paymentService.getAll());
    }


}
