package com.beauty.api.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.beauty.api.dto.EvaluateDTO;
import java.util.List;
/**
* @description: 订单评价业务层接口
* @author: beautyAuthor
* @create: 2024.11.13 11:28:25
*/
public interface EvaluateService extends IService<EvaluateDTO> {

    /**
    * 默认分页方法
    * @param evaluateDTO
    * @return
    */
    Page<EvaluateDTO> basePage(EvaluateDTO evaluateDTO);


    /**
    * 根据XML中的sql语句进行查询
    * @param evaluateDTO
    * @return
    */
    List<EvaluateDTO> findList(EvaluateDTO evaluateDTO);

}
