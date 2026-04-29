package com.beauty.api.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.beauty.api.entity. Evaluate;
import lombok.Data;
import lombok.ToString;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
* @description: 订单评价数据传输层
* @author: beautyAuthor
* @create: 2024.11.13 11:28:25
*/
@Data
@ToString
@TableName("evaluate")
public class EvaluateDTO extends Evaluate {

    /**
    * 订单号
    */
    @TableField(exist = false)
    private String orderNo;
    /**
    * 标题
    */
    @TableField(exist = false)
    private String title;
    /**
    * 昵称
    */
    @TableField(exist = false)
    private String nickName;
    /**
    * 头像
    */
    @TableField(exist = false)
    private String avatar;

}
