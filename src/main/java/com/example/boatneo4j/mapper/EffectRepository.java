package com.example.boatneo4j.mapper;

import com.example.boatneo4j.pojo.BaseNutritionNode;
import com.example.boatneo4j.pojo.EffectNode;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EffectRepository extends Neo4jRepository<EffectNode,String> {
}
