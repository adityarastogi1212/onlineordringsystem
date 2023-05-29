package com.payment.service.services;


import com.payment.service.entites.Payment;

import java.util.List;

public interface PaymentService {

    //create

    Payment create(Payment payment);

    //get all
    List<Payment> getAll();

    //get single
    Payment get(String id);

}
