package com.beauty.api.entity;

import com.beauty.api.common.BaseEntity;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
/**
* @description: 项目预约实体类
* @author: beautyAuthor
* @create: 2024.11.13 11:28:25
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Subscribes extends BaseEntity {

    /**
    * 预约编号
    */
    private Long id;
    /**
    * 项目编号
    */
    private Long projectId;
    private Long orderId;
    private Long bid;
    /**
    * 用户编号
    */
    private Long userId;
    /**
    * 预约时间
    */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date startTime;
    /**
    * 创建时间
    */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;
    /**
    * 状态
    */
    private Integer status;


}
