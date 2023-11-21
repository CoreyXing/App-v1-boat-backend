package com.example.boatneo4j.mapper;

import com.example.boatneo4j.pojo.AminoAcidNode;
import com.example.boatneo4j.pojo.BaseNutritionNode;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BaseNutritionRepository extends Neo4jRepository<BaseNutritionNode,String> {
}
