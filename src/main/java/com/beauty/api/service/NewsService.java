package com.beauty.api.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.beauty.api.dto.NewsDTO;
import java.util.List;
/**
* @description: 新闻资讯业务层接口
* @author: beautyAuthor
* @create: 2024.11.13 11:28:25
*/
public interface NewsService extends IService<NewsDTO> {

    /**
    * 默认分页方法
    * @param newsDTO
    * @return
    */
    Page<NewsDTO> basePage(NewsDTO newsDTO);


    /**
    * 根据XML中的sql语句进行查询
    * @param newsDTO
    * @return
    */
    List<NewsDTO> findList(NewsDTO newsDTO);

}
