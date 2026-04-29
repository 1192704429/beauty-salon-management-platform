package com.beauty.api.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.beauty.api.entity. Orders;
import lombok.Data;
import lombok.ToString;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
* @description: 美容订单数据传输层
* @author: beautyAuthor
* @create: 2024.11.13 11:28:25
*/
@Data
@ToString
@TableName("orders")
public class OrdersDTO extends Orders {

    /**
    * 用户昵称
    */
    @TableField(exist = false)
    private String nickName;
    /**
    * 头像
    */
    @TableField(exist = false)
    private String avatar;
    /**
    * 美容项目
    */
    @TableField(exist = false)
    private String title;
    /**
    * 工号
    */
    @TableField(exist = false)
    private String jobId;
    /**
    * 美容师姓名
    */
    @TableField(exist = false)
    private String name;


    @TableField(exist = false)
    private String month;


}
