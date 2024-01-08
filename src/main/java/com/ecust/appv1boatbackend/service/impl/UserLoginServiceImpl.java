package com.ecust.appv1boatbackend.service.impl;

import com.ecust.appv1boatbackend.Exception.LoginFailedException;
import com.ecust.appv1boatbackend.Repository.UserLoginRepository;
import com.ecust.appv1boatbackend.service.UserLoginService;
import com.ecust.appv1boatbackend.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserLoginServiceImpl implements UserLoginService {



    @Autowired
    private UserLoginRepository userLoginRepository;

    @Override
    public String userLogin(String name,String password) {
        String id = userLoginRepository.queryIdWithNameAndPassword(name,password);
        if(id == null){
            throw new LoginFailedException();
        }
        String jwtToken = JwtUtil.getJwtToken(id, name);
        return jwtToken;

    }

    @Override
    public String getIdByToken(String token) {
        boolean isValid = JwtUtil.checkToken(token);
        if(!isValid){
            throw new LoginFailedException();
        }
        String id = JwtUtil.getMemberIdByJwtToken(token);
        return id;
    }

    @Override
    public boolean checkTokenValid(String token){
        String id = JwtUtil.getMemberIdByJwtToken(token);
        if (id == null){
            return false;
        }
        return true;
    }

}
