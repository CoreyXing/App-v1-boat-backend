package com.example.boatneo4j.mapper;

import com.example.boatneo4j.pojo.EffectNode;
import com.example.boatneo4j.pojo.SecondLevelFoodNode;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SecondLevelFoodRepository extends Neo4jRepository<SecondLevelFoodNode,String> {
}
