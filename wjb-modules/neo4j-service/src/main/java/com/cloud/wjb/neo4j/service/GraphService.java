package com.cloud.wjb.neo4j.service;

import com.cloud.wjb.neo4j.pojo.CustomerNode;

import java.util.List;

public interface GraphService {
    void deleteNodeById(Long id);

    void deleteNodeByName(String name);

    void delete();

    void addNode(String name, Integer age, String nameTo, String remark, String phone);

    void updateNode(Long id, String name, Integer age);

    Iterable<CustomerNode> queryNodes();

    CustomerNode findByName(String name);

    List<CustomerNode> queryNodes(String name);
}