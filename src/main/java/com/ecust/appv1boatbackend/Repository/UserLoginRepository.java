package com.ecust.appv1boatbackend.Repository;

public interface UserLoginRepository {
    String queryIdWithNameAndPassword(String name,String password);
}
