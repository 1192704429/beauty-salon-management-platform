package com.beauty.api.controller;

import com.beauty.api.common.BaseController;
import com.beauty.api.common.BaseSelectEntity;
import com.beauty.api.common.ReturnMsg;
import com.beauty.api.dto.*;
import com.beauty.api.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @description: 项目预约对外接口层
 * @author: beautyAuthor
 * @create: 2024.11.13 11:28:25
 */
@RestController
@RequestMapping("/subscribes")
public class SubscribesController extends BaseController<SubscribesService, SubscribesDTO> {

    @Autowired
    private BeautyProjectsService beautyProjectsService;
    @Autowired
    private UserService userService;

    @Autowired
    private OrdersService ordersService;

    @Autowired
    private BeauticianService beauticianService;

    @Override
    @Resource(name = "subscribesService")
    protected void setBaseService(SubscribesService subscribesService) {
        this.baseService = subscribesService;
    }

    /**
     * 默认分页查询
     *
     * @param subscribesDTO
     * @return
     */
    @PostMapping("/page")
    public ReturnMsg page(@RequestBody SubscribesDTO subscribesDTO) {
        return ReturnMsg.ok(baseService.basePage(subscribesDTO));
    }

    /**
     * 根据XML中的sql语句进行查询
     *
     * @param subscribesDTO
     * @return
     */
    @PostMapping(value = "/findList")
    public ReturnMsg findList(@RequestBody SubscribesDTO subscribesDTO) {
        return ReturnMsg.ok(baseService.findList(subscribesDTO));
    }

    @Override
    protected void beforeSave(SubscribesDTO entity) throws Exception {
        entity.setCreateTime(new Date());
        super.beforeSave(entity);
    }


    @Override
    protected void beforeUpdate(SubscribesDTO entity) throws Exception {
        // 待支付
        if (entity.getStatus().equals(3)) {
            OrdersDTO ordersDTO = new OrdersDTO();
            ordersDTO.setUserId(entity.getUserId());
            ordersDTO.setProjectId(entity.getProjectId());
            ordersDTO.setBeauticianId(entity.getBid());
            ordersDTO.setCreateTime(new Date());
            ordersDTO.setStatus(0);
            String orderId = System.currentTimeMillis() + "";
            ordersDTO.setOrderNo(orderId);
            ordersService.save(ordersDTO);
            entity.setOrderId(ordersDTO.getId());
        }
        // 已完成
        if (entity.getStatus().equals(1)) {
            OrdersDTO ordersDTO = ordersService.getById(entity.getOrderId());
            ordersDTO.setStatus(2);
            ordersDTO.setMoney(entity.getPrice());
            ordersService.updateById(ordersDTO);
        }
        super.beforeUpdate(entity);
    }

    @GetMapping("/all/beautyProjects")
    public ReturnMsg allBeautyProjects() {
        List<BaseSelectEntity> list = new ArrayList<>();
        List<BeautyProjectsDTO> dtos = beautyProjectsService.list();
        for (BeautyProjectsDTO dto : dtos) {
            BaseSelectEntity baseSelectEntity = new BaseSelectEntity();
            baseSelectEntity.setKey(dto.getId());
            baseSelectEntity.setValue(dto.getTitle());
            list.add(baseSelectEntity);
        }
        return ReturnMsg.ok(list);
    }


    @GetMapping("/all/beauty")
    public ReturnMsg allBeauty() {
        List<BaseSelectEntity> list = new ArrayList<>();
        List<BeauticianDTO> dtos = beauticianService.list();
        for (BeauticianDTO dto : dtos) {
            BaseSelectEntity baseSelectEntity = new BaseSelectEntity();
            baseSelectEntity.setKey(dto.getId());
            baseSelectEntity.setValue(dto.getName());
            list.add(baseSelectEntity);
        }
        return ReturnMsg.ok(list);
    }

    @GetMapping("/all/user")
    public ReturnMsg allUser() {
        List<BaseSelectEntity> list = new ArrayList<>();
        List<UserDTO> dtos = userService.list();
        for (UserDTO dto : dtos) {
            BaseSelectEntity baseSelectEntity = new BaseSelectEntity();
            baseSelectEntity.setKey(dto.getId());
            baseSelectEntity.setValue(dto.getNickName());
            list.add(baseSelectEntity);
        }
        return ReturnMsg.ok(list);
    }

}

