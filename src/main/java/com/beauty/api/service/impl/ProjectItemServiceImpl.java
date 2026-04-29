package com.beauty.api.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.beauty.api.dao.ProjectItemDao;
import com.beauty.api.dto.ProjectItemDTO;
import com.beauty.api.service.ProjectItemService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @description: 项目消耗业务层实现类
* @author: beautyAuthor
* @create: 2024.11.13 11:28:25
*/
@Service("projectItemService")
public class ProjectItemServiceImpl extends ServiceImpl<ProjectItemDao, ProjectItemDTO> implements ProjectItemService {

    @Override
    public Page<ProjectItemDTO> basePage(ProjectItemDTO projectItemDTO) {
        if (null != projectItemDTO.getCurrent() && null != projectItemDTO.getPageSize())
            projectItemDTO.setCurrent((projectItemDTO.getCurrent() - 1) * projectItemDTO.getPageSize());
        List<ProjectItemDTO> list = this.baseMapper.findList(projectItemDTO);
        int count = this.baseMapper.findPageCount(projectItemDTO);
        Page<ProjectItemDTO> page = new Page<>();
        page.setTotal(count);
        page.setRecords(list);
        return page;
    }

    @Override
    public List<ProjectItemDTO> findList(ProjectItemDTO projectItemDTO) {
        return this.baseMapper.findList(projectItemDTO);
    }

}
