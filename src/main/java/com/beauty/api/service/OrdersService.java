package com.beauty.api.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.beauty.api.dto.DataDTO;
import com.beauty.api.dto.OrdersDTO;
import java.util.List;
/**
* @description: 美容订单业务层接口
* @author: beautyAuthor
* @create: 2024.11.13 11:28:25
*/
public interface OrdersService extends IService<OrdersDTO> {

    /**
    * 默认分页方法
    * @param ordersDTO
    * @return
    */
    Page<OrdersDTO> basePage(OrdersDTO ordersDTO);


    /**
    * 根据XML中的sql语句进行查询
    * @param ordersDTO
    * @return
    */
    List<OrdersDTO> findList(OrdersDTO ordersDTO);


    List<OrdersDTO> selectProjectCount(Integer num);

    List<DataDTO> getMoneyNum(int i);

    List<DataDTO> getProjectCount();
}
