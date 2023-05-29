package com.status.service.repository;

import com.status.service.entities.Status;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface StatusRepository extends JpaRepository<Status,String>
{
    //custom finder methods
    List<Status> findByUserId(String userId);
    List<Status> findByPaymentId(String paymentId);

}
