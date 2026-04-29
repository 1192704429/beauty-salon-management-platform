package com.beauty.api.entity;

import com.beauty.api.common.BaseEntity;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
/**
* @description: 美容项目实体类
* @author: beautyAuthor
* @create: 2024.11.13 11:28:25
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BeautyProjects extends BaseEntity {

    /**
    * 项目编号
    */
    private Long id;
    /**
    * 标题
    */
    private String title;
    /**
    * 简介
    */
    private String info;
    /**
    * 价格
    */
    private BigDecimal price;
    /**
    * 详情
    */
    private String detail;
    /**
    * 封面图片
    */
    private String coverImg;
    /**
    * 创建时间
    */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;
    /**
    * 状态
    */
    private Integer status;
    private Integer banner;


}
