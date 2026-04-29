package com.beauty.api.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.beauty.api.dao.ItemsDao;
import com.beauty.api.dto.ItemsDTO;
import com.beauty.api.service.ItemsService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @description: 美容物品业务层实现类
* @author: beautyAuthor
* @create: 2024.11.13 11:28:25
*/
@Service("itemsService")
public class ItemsServiceImpl extends ServiceImpl<ItemsDao, ItemsDTO> implements ItemsService {

    @Override
    public Page<ItemsDTO> basePage(ItemsDTO itemsDTO) {
        if (null != itemsDTO.getCurrent() && null != itemsDTO.getPageSize())
            itemsDTO.setCurrent((itemsDTO.getCurrent() - 1) * itemsDTO.getPageSize());
        List<ItemsDTO> list = this.baseMapper.findList(itemsDTO);
        int count = this.baseMapper.findPageCount(itemsDTO);
        Page<ItemsDTO> page = new Page<>();
        page.setTotal(count);
        page.setRecords(list);
        return page;
    }

    @Override
    public List<ItemsDTO> findList(ItemsDTO itemsDTO) {
        return this.baseMapper.findList(itemsDTO);
    }

}
