package com.beauty.api.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.beauty.api.entity. ProjectItem;
import lombok.Data;
import lombok.ToString;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
* @description: 项目消耗数据传输层
* @author: beautyAuthor
* @create: 2024.11.13 11:28:25
*/
@Data
@ToString
@TableName("project_item")
public class ProjectItemDTO extends ProjectItem {

    /**
    * 标题
    */
    @TableField(exist = false)
    private String title;
    /**
    * 物品名称
    */
    @TableField(exist = false)
    private String name;
    /**
    * 封面图片
    */
    @TableField(exist = false)
    private String img;

}
