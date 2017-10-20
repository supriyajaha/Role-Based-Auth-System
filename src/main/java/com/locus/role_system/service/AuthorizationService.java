package com.locus.role_system.service;


import com.locus.role_system.request_response.AuthorizationResponse;

public interface AuthorizationService {

    AuthorizationResponse isAuthorized(String username, String resource, String action);
}
