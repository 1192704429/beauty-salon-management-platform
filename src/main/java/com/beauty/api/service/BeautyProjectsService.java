package com.beauty.api.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.beauty.api.dto.BeautyProjectsDTO;
import java.util.List;
/**
* @description: 美容项目业务层接口
* @author: beautyAuthor
* @create: 2024.11.13 11:28:25
*/
public interface BeautyProjectsService extends IService<BeautyProjectsDTO> {

    /**
    * 默认分页方法
    * @param beautyProjectsDTO
    * @return
    */
    Page<BeautyProjectsDTO> basePage(BeautyProjectsDTO beautyProjectsDTO);


    /**
    * 根据XML中的sql语句进行查询
    * @param beautyProjectsDTO
    * @return
    */
    List<BeautyProjectsDTO> findList(BeautyProjectsDTO beautyProjectsDTO);

}
