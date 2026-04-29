package com.beauty.api.entity;

import com.beauty.api.common.BaseEntity;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
/**
* @description: 订单评价实体类
* @author: beautyAuthor
* @create: 2024.11.13 11:28:25
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Evaluate extends BaseEntity {

    /**
    * 评价编号
    */
    private Long id;
    /**
    * 订单编号
    */
    private Long orderId;
    /**
    * 项目编号
    */
    private Long projectId;
    /**
    * 用户编号
    */
    private Long userId;
    /**
    * 评价内容
    */
    private String content;
    private String info;
    /**
    * 评价时间
    */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;


}
