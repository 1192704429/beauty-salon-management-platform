package com.beauty.api.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.beauty.api.dto.DataDTO;
import com.beauty.api.dto.UserDTO;
import java.util.List;
/**
* @description: 用户管理业务层接口
* @author: beautyAuthor
* @create: 2024.11.13 11:28:25
*/
public interface UserService extends IService<UserDTO> {

    /**
    * 默认分页方法
    * @param userDTO
    * @return
    */
    Page<UserDTO> basePage(UserDTO userDTO);


    /**
    * 根据XML中的sql语句进行查询
    * @param userDTO
    * @return
    */
    List<UserDTO> findList(UserDTO userDTO);

    List<DataDTO> getNumBySex();
}
