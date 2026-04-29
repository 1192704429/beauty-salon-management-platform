package com.beauty.api.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.beauty.api.dao.OrdersDao;
import com.beauty.api.dto.DataDTO;
import com.beauty.api.dto.OrdersDTO;
import com.beauty.api.service.OrdersService;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

/**
* @description: 美容订单业务层实现类
* @author: beautyAuthor
* @create: 2024.11.13 11:28:25
*/
@Service("ordersService")
public class OrdersServiceImpl extends ServiceImpl<OrdersDao, OrdersDTO> implements OrdersService {

    @Override
    public Page<OrdersDTO> basePage(OrdersDTO ordersDTO) {
        if (null != ordersDTO.getCurrent() && null != ordersDTO.getPageSize())
            ordersDTO.setCurrent((ordersDTO.getCurrent() - 1) * ordersDTO.getPageSize());
        List<OrdersDTO> list = this.baseMapper.findList(ordersDTO);
        int count = this.baseMapper.findPageCount(ordersDTO);
        Page<OrdersDTO> page = new Page<>();
        page.setTotal(count);
        page.setRecords(list);
        return page;
    }

    @Override
    public List<OrdersDTO> findList(OrdersDTO ordersDTO) {
        return this.baseMapper.findList(ordersDTO);
    }

    @Override
    public List<OrdersDTO> selectProjectCount(Integer num) {
        return this.baseMapper.selectProjectCount(num);
    }

    @Override
    public List<DataDTO> getMoneyNum(int i) {
        return this.baseMapper.getMoneyNum(i);
    }

    @Override
    public List<DataDTO> getProjectCount() {
        return this.baseMapper.getProjectCount();
    }

}
