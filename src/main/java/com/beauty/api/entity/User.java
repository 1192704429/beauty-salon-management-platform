package com.beauty.api.entity;

import com.beauty.api.common.BaseEntity;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
/**
* @description: 用户管理实体类
* @author: beautyAuthor
* @create: 2024.11.13 11:28:25
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User extends BaseEntity {

    /**
    * 编号
    */
    private Long id;
    /**
    * 用户名
    */
    private String username;
    /**
    * 密码
    */
    private String password;
    /**
    * 昵称
    */
    private String nickName;
    /**
    * 头像
    */
    private String avatar;
    /**
    * 年龄
    */
    private Integer age;
    /**
    * 性别
    */
    private Integer sex;
    /**
    * 手机号
    */
    private String tel;
    /**
    * 简介
    */
    private String info;
    /**
    * 创建时间
    */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;


}
