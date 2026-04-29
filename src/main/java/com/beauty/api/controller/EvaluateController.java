package com.beauty.api.controller;

import com.beauty.api.common.BaseController;
import com.beauty.api.common.ReturnMsg;
import com.beauty.api.dto.EvaluateDTO;
import com.beauty.api.service.EvaluateService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import com.beauty.api.common.BaseSelectEntity;
import java.util.ArrayList;
import com.beauty.api.service.OrdersService;
import com.beauty.api.dto.OrdersDTO;
import com.beauty.api.service.BeautyProjectsService;
import com.beauty.api.dto.BeautyProjectsDTO;
import com.beauty.api.service.UserService;
import com.beauty.api.dto.UserDTO;
import javax.annotation.Resource;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.util.List;
import com.beauty.api.common.BaseSelectEntity;
import cn.hutool.core.collection.CollectionUtil;
import java.util.Date;
/**
* @description: 订单评价对外接口层
* @author: beautyAuthor
* @create: 2024.11.13 11:28:25
*/
@RestController
@RequestMapping("/evaluate")
public class EvaluateController extends BaseController<EvaluateService, EvaluateDTO> {

    @Autowired
    private OrdersService ordersService;
    @Autowired
    private BeautyProjectsService beautyProjectsService;
    @Autowired
    private UserService userService;

    @Override
    @Resource(name = "evaluateService")
    protected void setBaseService(EvaluateService evaluateService) {
        this.baseService = evaluateService;
    }

    /**
    * 默认分页查询
    * @param evaluateDTO
    * @return
    */
    @PostMapping("/page")
    public ReturnMsg page(@RequestBody EvaluateDTO evaluateDTO) {
        return ReturnMsg.ok(baseService.basePage(evaluateDTO));
    }

    /**
    * 根据XML中的sql语句进行查询
    * @param evaluateDTO
    * @return
    */
    @PostMapping(value = "/findList")
    public ReturnMsg findList(@RequestBody EvaluateDTO evaluateDTO) {
        return ReturnMsg.ok(baseService.findList(evaluateDTO));
    }

    @Override
    protected void beforeSave(EvaluateDTO entity) throws Exception {
        entity.setCreateTime(new Date());
        super.beforeSave(entity);
    }

    @GetMapping("/all/orders")
    public ReturnMsg allOrders() {
        List<BaseSelectEntity> list = new ArrayList<>();
        List<OrdersDTO> dtos = ordersService.list();
            for (OrdersDTO dto : dtos) {
            BaseSelectEntity baseSelectEntity = new BaseSelectEntity();
            baseSelectEntity.setKey(dto.getId());
            baseSelectEntity.setValue(dto.getOrderNo());
            list.add(baseSelectEntity);
        }
        return ReturnMsg.ok(list);
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

