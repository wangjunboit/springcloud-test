package com.cloud.wjb.neo4j.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.neo4j.ogm.annotation.*;

import java.util.Date;

@RelationshipEntity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerRelation {
    @Id
    @GeneratedValue
    private Long id;
    private Date createTime;
    private String remark;

    @StartNode
    private CustomerNode customerFrom;

    @EndNode
    private CustomerNode customerTo;

    public CustomerRelation(CustomerNode customerFrom, CustomerNode customerTo, String remark) {
        this.customerFrom = customerFrom;
        this.customerTo = customerTo;
        this.remark = remark;
    }
}