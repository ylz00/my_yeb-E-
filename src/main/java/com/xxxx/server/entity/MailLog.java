package com.xxxx.server.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author server
 * @since 2021-05-03
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_mail_log")
@ApiModel(value="MailLog对象", description="")
public class MailLog implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "消息id")
    @TableId(value = "msgId", type = IdType.AUTO)
    private String msgId;

    @ApiModelProperty(value = "接收员工id")
    private Integer eid;

    @ApiModelProperty(value = "状态（0:消息投递中 1:投递成功 2:投递失败）")
    private Integer status;

    @ApiModelProperty(value = "路由键")
    @TableField("routeKey")
    private String routeKey;

    @ApiModelProperty(value = "交换机")
    private String exchange;

    @ApiModelProperty(value = "重试次数")
    private Integer count;

    @ApiModelProperty(value = "重试时间")
    @TableField("tryTime")
    private Date tryTime;

    @ApiModelProperty(value = "创建时间")
    @TableField("createTime")
    private Date createTime;

    @ApiModelProperty(value = "更新时间")
    @TableField("updateTime")
    private Date updateTime;


}
