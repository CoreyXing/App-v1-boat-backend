package com.example.boatneo4j.pojo;

import lombok.Data;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;

import java.io.Serializable;

@Data
@Node("vitamin")
public class VitaminNode implements Serializable {

    @Id
    private String id;

    @Property("type")
    private String type;

    // 可以添加其他属性和方法
}
