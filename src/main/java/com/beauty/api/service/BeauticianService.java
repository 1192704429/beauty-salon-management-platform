package com.beauty.api.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.beauty.api.dto.BeauticianDTO;
import java.util.List;
/**
* @description: 美容师管理业务层接口
* @author: beautyAuthor
* @create: 2024.11.13 11:28:25
*/
public interface BeauticianService extends IService<BeauticianDTO> {

    /**
    * 默认分页方法
    * @param beauticianDTO
    * @return
    */
    Page<BeauticianDTO> basePage(BeauticianDTO beauticianDTO);


    /**
    * 根据XML中的sql语句进行查询
    * @param beauticianDTO
    * @return
    */
    List<BeauticianDTO> findList(BeauticianDTO beauticianDTO);

}
