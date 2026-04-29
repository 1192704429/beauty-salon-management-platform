package com.beauty.api.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.beauty.api.dto.AdminsDTO;
import java.util.List;
/**
* @description: 管理员管理业务层接口
* @author: beautyAuthor
* @create: 2024.11.13 11:28:25
*/
public interface AdminsService extends IService<AdminsDTO> {

    /**
    * 默认分页方法
    * @param adminsDTO
    * @return
    */
    Page<AdminsDTO> basePage(AdminsDTO adminsDTO);


    /**
    * 根据XML中的sql语句进行查询
    * @param adminsDTO
    * @return
    */
    List<AdminsDTO> findList(AdminsDTO adminsDTO);

}
