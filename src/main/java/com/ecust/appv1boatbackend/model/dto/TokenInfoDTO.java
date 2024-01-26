package com.ecust.appv1boatbackend.model.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TokenInfoDTO {


    private String token;

    private String expiretime;
}
