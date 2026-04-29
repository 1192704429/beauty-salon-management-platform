package com.beauty.api.entity;

import com.beauty.api.common.BaseEntity;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
/**
* @description: 美容师管理实体类
* @author: beautyAuthor
* @create: 2024.11.13 11:28:25
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Beautician extends BaseEntity {

    /**
    * 编号
    */
    private Long id;
    /**
    * 工号
    */
    private String jobId;
    /**
    * 姓名
    */
    private String name;
    /**
    * 账号
    */
    private String username;
    /**
    * 密码
    */
    private String password;
    /**
    * 性别
    */
    private Integer sex;
    /**
    * 年龄
    */
    private Integer age;
    /**
    * 头像
    */
    private String avatar;
    /**
    * 个人简介
    */
    private String info;
    /**
    * 当前状态
    */
    private Integer status;
    private Integer recomment;
    /**
    * 创建时间
    */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;


}
