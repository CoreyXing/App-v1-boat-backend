package com.ecust.appv1boatbackend.controller;

import com.ecust.appv1boatbackend.Exception.LoginFailedException;
import com.ecust.appv1boatbackend.model.dto.UserLoginDTO;
import com.ecust.appv1boatbackend.service.UserLoginService;
import com.google.common.base.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/login")
public class UserTokenController {

    @Autowired
    private UserLoginService userLoginService;

    @PostMapping("/token")
    public ResponseEntity<String> userLoginController(@RequestBody UserLoginDTO userLoginDTO){
        String name = userLoginDTO.getName();
        String password =userLoginDTO.getPassword();
        String token = userLoginService.userLogin(name,password);
        return ResponseEntity.ok().body(token);
    }

    @PostMapping("/id")
    public ResponseEntity<String> getIdWithToken(@RequestHeader("Authorization") String token){
        if(Strings.isNullOrEmpty(token)){
            throw new LoginFailedException();
        }
        String id = userLoginService.getIdByToken(token);
        return ResponseEntity.ok().body(id);
    }

}
