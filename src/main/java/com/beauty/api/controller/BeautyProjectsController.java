package com.beauty.api.controller;

import cn.hutool.core.collection.CollectionUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.beauty.api.common.BaseController;
import com.beauty.api.common.ReturnMsg;
import com.beauty.api.dto.BeautyProjectsDTO;
import com.beauty.api.dto.OrdersDTO;
import com.beauty.api.service.BeautyProjectsService;
import com.beauty.api.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @description: 美容项目对外接口层
 * @author: beautyAuthor
 * @create: 2024.11.13 11:28:25
 */
@RestController
@RequestMapping("/beautyProjects")
public class BeautyProjectsController extends BaseController<BeautyProjectsService, BeautyProjectsDTO> {


    @Autowired
    private OrdersService ordersService;

    @Override
    @Resource(name = "beautyProjectsService")
    protected void setBaseService(BeautyProjectsService beautyProjectsService) {
        this.baseService = beautyProjectsService;
    }

    /**
     * 默认分页查询
     *
     * @param beautyProjectsDTO
     * @return
     */
    @PostMapping("/page")
    public ReturnMsg page(@RequestBody BeautyProjectsDTO beautyProjectsDTO) {
        return ReturnMsg.ok(baseService.basePage(beautyProjectsDTO));
    }


    @GetMapping("/recommend/{num}")
    public ReturnMsg recommendProject(@PathVariable Integer num) {
        LambdaQueryWrapper<BeautyProjectsDTO> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.orderByDesc(BeautyProjectsDTO::getCreateTime).in(BeautyProjectsDTO::getBanner, 2)
                .eq(BeautyProjectsDTO::getStatus, 1);
        List<BeautyProjectsDTO> listed = baseService.list(queryWrapper);
        return ReturnMsg.ok(listed);
    }


    /**
     * 根据XML中的sql语句进行查询
     *
     * @param beautyProjectsDTO
     * @return
     */
    @PostMapping(value = "/findList")
    public ReturnMsg findList(@RequestBody BeautyProjectsDTO beautyProjectsDTO) {
        return ReturnMsg.ok(baseService.findList(beautyProjectsDTO));
    }

    @Override
    protected void beforeSave(BeautyProjectsDTO entity) throws Exception {
        entity.setCreateTime(new Date());
        super.beforeSave(entity);
    }

}

