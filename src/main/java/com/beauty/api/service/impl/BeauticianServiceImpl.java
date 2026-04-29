package com.beauty.api.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.beauty.api.dao.BeauticianDao;
import com.beauty.api.dto.BeauticianDTO;
import com.beauty.api.service.BeauticianService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @description: 美容师管理业务层实现类
* @author: beautyAuthor
* @create: 2024.11.13 11:28:25
*/
@Service("beauticianService")
public class BeauticianServiceImpl extends ServiceImpl<BeauticianDao, BeauticianDTO> implements BeauticianService {

    @Override
    public Page<BeauticianDTO> basePage(BeauticianDTO beauticianDTO) {
        if (null != beauticianDTO.getCurrent() && null != beauticianDTO.getPageSize())
            beauticianDTO.setCurrent((beauticianDTO.getCurrent() - 1) * beauticianDTO.getPageSize());
        List<BeauticianDTO> list = this.baseMapper.findList(beauticianDTO);
        int count = this.baseMapper.findPageCount(beauticianDTO);
        Page<BeauticianDTO> page = new Page<>();
        page.setTotal(count);
        page.setRecords(list);
        return page;
    }

    @Override
    public List<BeauticianDTO> findList(BeauticianDTO beauticianDTO) {
        return this.baseMapper.findList(beauticianDTO);
    }

}
