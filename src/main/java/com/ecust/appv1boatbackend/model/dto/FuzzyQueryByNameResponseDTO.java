package com.ecust.appv1boatbackend.model.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * 模糊查询返回对象
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FuzzyQueryByNameResponseDTO {
    private String id;
    private String name;


}
