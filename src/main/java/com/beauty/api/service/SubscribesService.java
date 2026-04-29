package com.beauty.api.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.beauty.api.dto.SubscribesDTO;
import java.util.List;
/**
* @description: 项目预约业务层接口
* @author: beautyAuthor
* @create: 2024.11.13 11:28:25
*/
public interface SubscribesService extends IService<SubscribesDTO> {

    /**
    * 默认分页方法
    * @param subscribesDTO
    * @return
    */
    Page<SubscribesDTO> basePage(SubscribesDTO subscribesDTO);


    /**
    * 根据XML中的sql语句进行查询
    * @param subscribesDTO
    * @return
    */
    List<SubscribesDTO> findList(SubscribesDTO subscribesDTO);

}
