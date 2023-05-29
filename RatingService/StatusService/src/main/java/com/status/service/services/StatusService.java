package com.status.service.services;

import com.status.service.entities.Status;

import java.util.List;


public interface StatusService {

    //create
    Status create(Status status);


    //get all ratings
    List<Status> getStatus();

    //get all by UserId
    List<Status> getStatusByUserId(String userId);

    //get all by hotel
    List<Status> getStatusByPaymentId(String paymentId);




}
