package com.user.service.services;

import org.springframework.web.client.RestTemplate;
import com.user.service.entities.User;

import java.util.List;

public interface UserService {

    User saveUser(User user);

    List<User> getAllUser();

    User getUser(String userId);
}
