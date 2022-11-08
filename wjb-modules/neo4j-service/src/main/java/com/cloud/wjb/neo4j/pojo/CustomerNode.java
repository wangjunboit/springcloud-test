package com.cloud.wjb.neo4j.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerNode {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private Integer age;
    private String phone;
}