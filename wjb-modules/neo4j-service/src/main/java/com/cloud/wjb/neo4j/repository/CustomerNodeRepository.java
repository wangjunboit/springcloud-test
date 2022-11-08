package com.cloud.wjb.neo4j.repository;

import com.cloud.wjb.neo4j.pojo.CustomerNode;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;

import java.util.List;

public interface CustomerNodeRepository extends Neo4jRepository<CustomerNode, Long> {
    CustomerNode findByName(String name);

    CustomerNode deleteByName(String name);

    /**
     * 根据节点名称查找关系
     *
     * @param name
     * @return
     */
    @Query("MATCH c=(cf:CustomerNode)-[r:CustomerRelation]->(ct:CustomerNode) WHERE ct.name=$name OR cf.name=$name RETURN cf")
    List<CustomerNode> findRelationByCustomerNode(String name);

    @Query("MATCH c=(cf:CustomerNode) WHERE cf.id=$id RETURN cf")
    CustomerNode findNodeById(Long id);
}