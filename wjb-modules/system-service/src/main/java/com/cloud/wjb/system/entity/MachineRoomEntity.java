package com.cloud.wjb.system.entity;

import java.math.BigDecimal;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.time.LocalDateTime;

import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableField;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 机房管理表
 * </p>
 *
 * @author fuqiang
 * @since 2022-08-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("hw_machine_room")
@ApiModel(value = "MachineRoomEntity对象", description = "机房管理表")
public class MachineRoomEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "是否删除 0-正常 1-已删除")
    @TableField("is_delete")
    @TableLogic
    private Boolean isDelete;

    @ApiModelProperty(value = "机房名称")
    @TableField("room_name")
    private String roomName;

    @ApiModelProperty(value = "机房编号")
    @TableField("room_code")
    private String roomCode;

    @ApiModelProperty(value = "安全类型 1-无等级保护 2-等级保护二级 3-等级保护三级")
    @TableField("safety_type")
    private Boolean safetyType;

    @ApiModelProperty(value = "密码类型 1-非商业密码等级 2-商业密码二级 3-商业密码三级")
    @TableField("password_type")
    private Boolean passwordType;

    @ApiModelProperty(value = "机房模型编码")
    @TableField("room_model_code")
    private String roomModelCode;

    @ApiModelProperty(value = "机房模型名称")
    @TableField("room_model_name")
    private String roomModelName;

    @ApiModelProperty(value = "经度")
    @TableField("longitude")
    private BigDecimal longitude;

    @ApiModelProperty(value = "纬度")
    @TableField("latitude")
    private BigDecimal latitude;

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
