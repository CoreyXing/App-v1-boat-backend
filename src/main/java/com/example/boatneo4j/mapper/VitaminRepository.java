package com.example.boatneo4j.mapper;

import com.example.boatneo4j.pojo.EffectNode;
import com.example.boatneo4j.pojo.VitaminNode;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository
public interface VitaminRepository extends Neo4jRepository<VitaminNode,String> {
}
