package com.example.boatneo4j.mapper;

import com.example.boatneo4j.pojo.EffectNode;
import com.example.boatneo4j.pojo.FirstLevelFoodNode;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FirstLevelFoodRepository extends Neo4jRepository<FirstLevelFoodNode,String> {
}
