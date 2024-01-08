package com.ecust.appv1boatbackend.service;

public interface UserLoginService {
    String userLogin(String name,String password);

    String getIdByToken(String token);

    boolean checkTokenValid(String token);
}
