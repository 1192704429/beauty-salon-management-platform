package com.beauty.api.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.beauty.api.entity. Subscribes;
import lombok.Data;
import lombok.ToString;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
* @description: 项目预约数据传输层
* @author: beautyAuthor
* @create: 2024.11.13 11:28:25
*/
@Data
@ToString
@TableName("subscribes")
public class SubscribesDTO extends Subscribes {

    /**
    * 美容项目
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
    /**
    * 手机号
    */
    @TableField(exist = false)
    private String tel;

    @TableField(exist = false)
    private String info;

    @TableField(exist = false)
    private String coverImg;
    @TableField(exist = false)
    private String price;

}
