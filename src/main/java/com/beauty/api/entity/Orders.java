package com.beauty.api.entity;

import com.beauty.api.common.BaseEntity;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
/**
* @description: 美容订单实体类
* @author: beautyAuthor
* @create: 2024.11.13 11:28:25
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Orders extends BaseEntity {

    /**
    * 订单编号
    */
    private Long id;
    /**
    * 用户编号
    */
    private Long userId;
    /**
    * 项目编号
    */
    private Long projectId;
    /**
    * 订单号
    */
    private String orderNo;
    /**
    * 美容师编号
    */
    private Long beauticianId;
    /**
    * 价格
    */
    private String money;
    /**
    * 状态
    */
    private Integer status;
    /**
    * 创建时间
    */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;
    /**
    * 完成时间
    */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date endTime;


}
