package com.beauty.api.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.beauty.api.entity. User;
import lombok.Data;
import lombok.ToString;

/**
* @description: 用户管理数据传输层
* @author: beautyAuthor
* @create: 2024.11.13 11:28:25
*/
@Data
@ToString
@TableName("user")
public class UserDTO extends User {


}
