package com.cloud.wjb.system.entity;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 机柜管理表
 * </p>
 *
 * @author fuqiang
 * @since 2022-08-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("hw_machine_cabinet")
@ApiModel(value = "MachineCabinetEntity对象", description = "机柜管理表")
public class MachineCabinetEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "是否删除 0-正常 1-已删除")
    @TableField("is_delete")
    @TableLogic
    private Boolean isDelete;

    @ApiModelProperty(value = "机房id")
    @TableField("room_id")
    private Integer roomId;

    @ApiModelProperty(value = "机柜名称")
    @TableField("cabinet_name")
    private String cabinetName;

    @ApiModelProperty(value = "机柜编号")
    @TableField("cabinet_code")
    private String cabinetCode;

    @ApiModelProperty(value = "机柜品牌")
    @TableField("cabinet_brand")
    private String cabinetBrand;

    @ApiModelProperty(value = "机柜型号")
    @TableField("cabinet_model")
    private String cabinetModel;

    @ApiModelProperty(value = "机柜容量")
    @TableField("capacity")
    private Integer capacity;

    @ApiModelProperty(value = "机柜ip")
    @TableField("ip")
    private String ip;

    @ApiModelProperty(value = "更新人")
    @TableField("update_by")
    private Integer updateBy;

    @ApiModelProperty(value = "更新时间")
    @TableField("update_time")
    private LocalDateTime updateTime;

    @ApiModelProperty(value = "创建人")
    @TableField("create_by")
    private Integer createBy;

    @ApiModelProperty(value = "创建时间")
    @TableField("create_time")
    private LocalDateTime createTime;


}
