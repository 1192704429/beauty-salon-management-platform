package com.beauty.api.entity;

import com.beauty.api.common.BaseEntity;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
/**
* @description: 项目消耗实体类
* @author: beautyAuthor
* @create: 2024.11.13 11:28:25
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ProjectItem extends BaseEntity {

    /**
    * 编号
    */
    private Long id;
    /**
    * 项目编号
    */
    private Long projectId;
    /**
    * 物品编号
    */
    private Long itemId;
    /**
    * 所需数量
    */
    private Integer num;
    /**
    * 创建时间
    */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;


}
