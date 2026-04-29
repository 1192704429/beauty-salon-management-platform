package com.beauty.api.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.beauty.api.entity. Beautician;
import lombok.Data;
import lombok.ToString;

/**
* @description: 美容师管理数据传输层
* @author: beautyAuthor
* @create: 2024.11.13 11:28:25
*/
@Data
@ToString
@TableName("beautician")
public class BeauticianDTO extends Beautician {


}
