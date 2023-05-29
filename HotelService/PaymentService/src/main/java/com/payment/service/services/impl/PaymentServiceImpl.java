package com.payment.service.services.impl;

import com.payment.service.entites.Payment;
import com.payment.service.exceptions.ResourceNotFoundException;
import com.payment.service.respositories.PaymentRepository;
import com.payment.service.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Override
    public Payment create(Payment payment) {
        String paymentId = UUID.randomUUID().toString();
        payment.setId(paymentId);
        return paymentRepository.save(payment);
    }

    @Override
    public List<Payment> getAll() {
        return paymentRepository.findAll();
    }

    @Override
    public Payment get(String id) {
        return paymentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("payment with given id not found !!"));
    }
}
