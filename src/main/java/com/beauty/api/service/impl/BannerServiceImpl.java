package com.beauty.api.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.beauty.api.dao.BannerDao;
import com.beauty.api.dto.BannerDTO;
import com.beauty.api.service.BannerService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @description: 轮播图管理业务层实现类
* @author: beautyAuthor
* @create: 2024.11.13 11:28:25
*/
@Service("bannerService")
public class BannerServiceImpl extends ServiceImpl<BannerDao, BannerDTO> implements BannerService {

    @Override
    public Page<BannerDTO> basePage(BannerDTO bannerDTO) {
        if (null != bannerDTO.getCurrent() && null != bannerDTO.getPageSize())
            bannerDTO.setCurrent((bannerDTO.getCurrent() - 1) * bannerDTO.getPageSize());
        List<BannerDTO> list = this.baseMapper.findList(bannerDTO);
        int count = this.baseMapper.findPageCount(bannerDTO);
        Page<BannerDTO> page = new Page<>();
        page.setTotal(count);
        page.setRecords(list);
        return page;
    }

    @Override
    public List<BannerDTO> findList(BannerDTO bannerDTO) {
        return this.baseMapper.findList(bannerDTO);
    }

}
