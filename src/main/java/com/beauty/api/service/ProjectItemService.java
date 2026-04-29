package com.beauty.api.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.beauty.api.dto.ProjectItemDTO;
import java.util.List;
/**
* @description: 项目消耗业务层接口
* @author: beautyAuthor
* @create: 2024.11.13 11:28:25
*/
public interface ProjectItemService extends IService<ProjectItemDTO> {

    /**
    * 默认分页方法
    * @param projectItemDTO
    * @return
    */
    Page<ProjectItemDTO> basePage(ProjectItemDTO projectItemDTO);


    /**
    * 根据XML中的sql语句进行查询
    * @param projectItemDTO
    * @return
    */
    List<ProjectItemDTO> findList(ProjectItemDTO projectItemDTO);

}
