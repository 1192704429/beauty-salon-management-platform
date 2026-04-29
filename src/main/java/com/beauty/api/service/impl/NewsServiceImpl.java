package com.beauty.api.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.beauty.api.dao.NewsDao;
import com.beauty.api.dto.NewsDTO;
import com.beauty.api.service.NewsService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @description: 新闻资讯业务层实现类
* @author: beautyAuthor
* @create: 2024.11.13 11:28:25
*/
@Service("newsService")
public class NewsServiceImpl extends ServiceImpl<NewsDao, NewsDTO> implements NewsService {

    @Override
    public Page<NewsDTO> basePage(NewsDTO newsDTO) {
        if (null != newsDTO.getCurrent() && null != newsDTO.getPageSize())
            newsDTO.setCurrent((newsDTO.getCurrent() - 1) * newsDTO.getPageSize());
        List<NewsDTO> list = this.baseMapper.findList(newsDTO);
        int count = this.baseMapper.findPageCount(newsDTO);
        Page<NewsDTO> page = new Page<>();
        page.setTotal(count);
        page.setRecords(list);
        return page;
    }

    @Override
    public List<NewsDTO> findList(NewsDTO newsDTO) {
        return this.baseMapper.findList(newsDTO);
    }

}
