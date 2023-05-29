package com.user.service.services.impl;

import org.springframework.web.client.RestTemplate;
import com.user.service.entities.Payment;
import com.user.service.entities.Status;
import com.user.service.entities.User;
import com.user.service.exceptions.ResourceNotFoundException;
//import com.user.service.external.services.PaymentService;
import com.user.service.repositories.UserRepository;
import com.user.service.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

//    @Autowired
//    private PaymentService paymentService;

    private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public User saveUser(User user) {
        String randomUserId = UUID.randomUUID().toString();
        user.setUserId(randomUserId);
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User getUser(String userId) {
//        return userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User with given id is not found on server !! : "+userId));
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User with given id is not found on server !! : " + userId));


        Status[] statusOfUser = restTemplate.getForObject("http://STATUS-SERVICE/status/users/" + user.getUserId(), Status[].class);
        logger.info("{} ", statusOfUser);

        List<Status> statuses = Arrays.stream(statusOfUser).toList();

        List<Status> statusList = statuses.stream().map(status -> {
            ResponseEntity<Payment> forEntity = restTemplate.getForEntity("http://PAYMENT-SERVICE/payments/"+status.getPaymentId(), Payment.class);
//            Payment payment = paymentService.getPayment(status.getPaymentId());
            Payment payment = forEntity.getBody();
            logger.info("response status code: {} ",forEntity.getStatusCode());
            status.setPayment(payment);
            return status;
        }).collect(Collectors.toList());

        user.setStatus(statusList);

        return user;

    }
}
