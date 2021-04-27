package com.spring.boot.app.soap.service;


import com.markcode.spring_booot_soap.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);

    private static final Map<String, User> users = new HashMap();

    @PostConstruct
    public void initialize() {
        LOGGER.info("UserService::initialize");
        User peter = new User();
        peter.setName("Peter");
        peter.setEmpId(111);
        peter.setSalary(12000);

        User sam = new User();
        sam.setName("Sam");
        sam.setEmpId(2222);
        sam.setSalary(13000);

        User ryan = new User();
        ryan.setName("Ryan");
        ryan.setEmpId(3333);
        ryan.setSalary(14000);

        users.put(peter.getName(),peter);
        users.put(sam.getName(),sam);
        users.put(ryan.getName(),ryan);
    }

    public User getUsers(String name) {
        LOGGER.info("UserService::getUsers");
        return users.get(name);
    }
}
