package com.beauty.api.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.beauty.api.dao.EvaluateDao;
import com.beauty.api.dto.EvaluateDTO;
import com.beauty.api.service.EvaluateService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @description: 订单评价业务层实现类
* @author: beautyAuthor
* @create: 2024.11.13 11:28:25
*/
@Service("evaluateService")
public class EvaluateServiceImpl extends ServiceImpl<EvaluateDao, EvaluateDTO> implements EvaluateService {

    @Override
    public Page<EvaluateDTO> basePage(EvaluateDTO evaluateDTO) {
        if (null != evaluateDTO.getCurrent() && null != evaluateDTO.getPageSize())
            evaluateDTO.setCurrent((evaluateDTO.getCurrent() - 1) * evaluateDTO.getPageSize());
        List<EvaluateDTO> list = this.baseMapper.findList(evaluateDTO);
        int count = this.baseMapper.findPageCount(evaluateDTO);
        Page<EvaluateDTO> page = new Page<>();
        page.setTotal(count);
        page.setRecords(list);
        return page;
    }

    @Override
    public List<EvaluateDTO> findList(EvaluateDTO evaluateDTO) {
        return this.baseMapper.findList(evaluateDTO);
    }

}
