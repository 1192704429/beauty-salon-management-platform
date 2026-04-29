package com.beauty.api.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.beauty.api.dao.BeautyProjectsDao;
import com.beauty.api.dto.BeautyProjectsDTO;
import com.beauty.api.service.BeautyProjectsService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @description: 美容项目业务层实现类
* @author: beautyAuthor
* @create: 2024.11.13 11:28:25
*/
@Service("beautyProjectsService")
public class BeautyProjectsServiceImpl extends ServiceImpl<BeautyProjectsDao, BeautyProjectsDTO> implements BeautyProjectsService {

    @Override
    public Page<BeautyProjectsDTO> basePage(BeautyProjectsDTO beautyProjectsDTO) {
        if (null != beautyProjectsDTO.getCurrent() && null != beautyProjectsDTO.getPageSize())
            beautyProjectsDTO.setCurrent((beautyProjectsDTO.getCurrent() - 1) * beautyProjectsDTO.getPageSize());
        List<BeautyProjectsDTO> list = this.baseMapper.findList(beautyProjectsDTO);
        int count = this.baseMapper.findPageCount(beautyProjectsDTO);
        Page<BeautyProjectsDTO> page = new Page<>();
        page.setTotal(count);
        page.setRecords(list);
        return page;
    }

    @Override
    public List<BeautyProjectsDTO> findList(BeautyProjectsDTO beautyProjectsDTO) {
        return this.baseMapper.findList(beautyProjectsDTO);
    }

}
