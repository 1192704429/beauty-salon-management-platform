package com.beauty.api.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.beauty.api.dao.SubscribesDao;
import com.beauty.api.dto.SubscribesDTO;
import com.beauty.api.service.SubscribesService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @description: 项目预约业务层实现类
* @author: beautyAuthor
* @create: 2024.11.13 11:28:25
*/
@Service("subscribesService")
public class SubscribesServiceImpl extends ServiceImpl<SubscribesDao, SubscribesDTO> implements SubscribesService {

    @Override
    public Page<SubscribesDTO> basePage(SubscribesDTO subscribesDTO) {
        if (null != subscribesDTO.getCurrent() && null != subscribesDTO.getPageSize())
            subscribesDTO.setCurrent((subscribesDTO.getCurrent() - 1) * subscribesDTO.getPageSize());
        List<SubscribesDTO> list = this.baseMapper.findList(subscribesDTO);
        int count = this.baseMapper.findPageCount(subscribesDTO);
        Page<SubscribesDTO> page = new Page<>();
        page.setTotal(count);
        page.setRecords(list);
        return page;
    }

    @Override
    public List<SubscribesDTO> findList(SubscribesDTO subscribesDTO) {
        return this.baseMapper.findList(subscribesDTO);
    }

}
