package com.locus.role_system.service;

import com.locus.role_system.data.dao.DataDaoImpl;
import com.locus.role_system.request_response.AuthorizationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("authorizationService")
public class AuthorizationServiceImpl implements AuthorizationService {
    @Autowired
    private DataDaoImpl dataDao;


    @Transactional
    public AuthorizationResponse isAuthorized(String username, String action, String resourceName) {
        Boolean isAuthorized = dataDao.isAuthorized(username, action, resourceName);
        return getAuthorizationResponse(isAuthorized);
    }

    private AuthorizationResponse getAuthorizationResponse(Boolean isAuthorized) {
        AuthorizationResponse authorizationResponse = new AuthorizationResponse();
        authorizationResponse.setAuthorized(isAuthorized);
        return authorizationResponse;
    }


}
