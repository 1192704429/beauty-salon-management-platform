package com.beauty.api.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.beauty.api.dto.ItemsDTO;
import java.util.List;
/**
* @description: 美容物品业务层接口
* @author: beautyAuthor
* @create: 2024.11.13 11:28:25
*/
public interface ItemsService extends IService<ItemsDTO> {

    /**
    * 默认分页方法
    * @param itemsDTO
    * @return
    */
    Page<ItemsDTO> basePage(ItemsDTO itemsDTO);


    /**
    * 根据XML中的sql语句进行查询
    * @param itemsDTO
    * @return
    */
    List<ItemsDTO> findList(ItemsDTO itemsDTO);

}
