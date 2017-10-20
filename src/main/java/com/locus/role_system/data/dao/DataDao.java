package com.locus.role_system.data.dao;


public interface DataDao {
    Boolean isAuthorized(String username, String resourceName, String action);
}
