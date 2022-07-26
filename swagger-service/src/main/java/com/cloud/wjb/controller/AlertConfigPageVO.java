/**
 * Copyright (C), 2015-2022, XXX有限公司
 * FileName: AlertConfigPageVO
 * Author:   wjb
 * Date:     2022/7/14 10:31
 * Description: 告警规则分页VO
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.cloud.wjb.controller;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * 〈一句话功能简述〉<br> 
 * 〈告警规则分页VO〉
 *
 * @author wjb
 * @create 2022/7/14
 * @since 1.0.0
 */
@Data
@ApiModel(value = "告警规则分页VO")
public class AlertConfigPageVO {
    @ApiModelProperty(value = "id",example = "1",required = true)
    private Integer id;

    @ApiModelProperty(value = "告警标识码",example = "G001",required = true)
    private String alertCode;

    @ApiModelProperty(value = "所属应用编码",example = "APP001",required = true)
    private String appCode;

    @ApiModelProperty(value = "所属应用",example = "森林消防",required = true)
    private String appName;

    @ApiModelProperty(value = "动态告警类型  1-短信 2-电话 3-IM通知",example = "1",required = true)
    private Integer dynamicNoticeType;

    @ApiModelProperty(value = "静态告警类型  1-短信 2-电话 3-IM通知",example = "1",required = true)
    private Integer staticNoticeType;

    @ApiModelProperty(value = "其他告警类型  1-短信 2-电话",example = "1",required = true)
    private Integer otherNoticeType;

    @ApiModelProperty(value = "创建时间",example = "2022-07-14 14:23:01",required = true)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:SS")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "启动状态 0-禁用 1-启用",example = "1",required = true)
    private Integer status;
}
