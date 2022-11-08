package com.cloud.wjb.neo4j.repository;

import com.cloud.wjb.neo4j.pojo.CustomerRelation;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface CustomerRelationRepository extends Neo4jRepository<CustomerRelation, Long> {

}