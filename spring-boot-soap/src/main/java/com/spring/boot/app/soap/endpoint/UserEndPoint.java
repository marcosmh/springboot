package com.spring.boot.app.soap.endpoint;

import com.markcode.spring_booot_soap.GetUserRequest;
import com.markcode.spring_booot_soap.GetUserResponse;
import com.spring.boot.app.soap.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class UserEndPoint {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserEndPoint.class);

    @Autowired
    private UserService userService;

    @PayloadRoot(namespace="http://markcode.com/spring-booot-soap",
                 localPart="getUserRequest")
    @ResponsePayload
    public GetUserResponse getUserRequest(@RequestPayload GetUserRequest request) {
        LOGGER.info("UserService::getUserRequest");
        GetUserResponse response = new GetUserResponse();
        response.setUser(userService.getUsers(request.getName()));
        return response;
    }

}
