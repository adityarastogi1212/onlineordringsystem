package com.status.service.controllers;

import com.status.service.entities.Status;
import com.status.service.services.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/status")
public class StatusController {

    @Autowired
    private StatusService statusService;

    //create rating
    @PostMapping
    public ResponseEntity<Status> create(@RequestBody Status statuses) {
        return ResponseEntity.status(HttpStatus.CREATED).body(statusService.create(statuses));
    }

    //get all
    @GetMapping
    public ResponseEntity<List<Status>> getStatus() {
        return ResponseEntity.ok(statusService.getStatus());
    }

    //get all of user
    @GetMapping("/users/{userId}")
    public ResponseEntity<List<Status>> getStatusByUserId(@PathVariable String userId) {
        return ResponseEntity.ok(statusService.getStatusByUserId(userId));
    }

    //get all of payments
    @GetMapping("/payments/{paymentId}")
    public ResponseEntity<List<Status>> getStatusByPaymentId(@PathVariable String paymentId) {
        return ResponseEntity.ok(statusService.getStatusByPaymentId(paymentId));
    }


}
