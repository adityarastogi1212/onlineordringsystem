package com.status.service.services.impl;

import com.status.service.entities.Status;
import com.status.service.repository.StatusRepository;
import com.status.service.services.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatusServiceImpl implements StatusService {


    @Autowired
    private StatusRepository repository;

    @Override
    public Status create(Status statuses) {
        return repository.save(statuses);
    }

    @Override
    public List<Status> getStatus() {
        return repository.findAll();
    }

    @Override
    public List<Status> getStatusByUserId(String userId) {
        return repository.findByUserId(userId);
    }

    @Override
    public List<Status> getStatusByPaymentId(String paymentId) {
        return repository.findByPaymentId(paymentId);
    }
}
