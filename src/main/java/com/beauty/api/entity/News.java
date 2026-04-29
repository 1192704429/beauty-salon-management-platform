package com.beauty.api.entity;

import com.beauty.api.common.BaseEntity;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
/**
* @description: 新闻资讯实体类
* @author: beautyAuthor
* @create: 2024.11.13 11:28:25
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class News extends BaseEntity {

    /**
    * 资讯编号
    */
    private Long id;
    /**
    * 资讯标题
    */
    private String title;
    /**
    * 封面图片
    */
    private String coverImg;
    /**
    * 资讯简介
    */
    private String content;
    /**
    * 详细内容
    */
    private String detail;
    /**
    * 状态
    */
    private Integer status;
    /**
    * 发布时间
    */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;


}
