package com.beauty.api.controller;

import com.beauty.api.common.BaseController;
import com.beauty.api.common.ReturnMsg;
import com.beauty.api.dto.ItemsDTO;
import com.beauty.api.service.ItemsService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import javax.annotation.Resource;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.util.List;
import com.beauty.api.common.BaseSelectEntity;
import cn.hutool.core.collection.CollectionUtil;
import java.util.Date;
/**
* @description: 美容物品对外接口层
* @author: beautyAuthor
* @create: 2024.11.13 11:28:25
*/
@RestController
@RequestMapping("/items")
public class ItemsController extends BaseController<ItemsService, ItemsDTO> {


    @Override
    @Resource(name = "itemsService")
    protected void setBaseService(ItemsService itemsService) {
        this.baseService = itemsService;
    }

    /**
    * 默认分页查询
    * @param itemsDTO
    * @return
    */
    @PostMapping("/page")
    public ReturnMsg page(@RequestBody ItemsDTO itemsDTO) {
        return ReturnMsg.ok(baseService.basePage(itemsDTO));
    }

    /**
    * 根据XML中的sql语句进行查询
    * @param itemsDTO
    * @return
    */
    @PostMapping(value = "/findList")
    public ReturnMsg findList(@RequestBody ItemsDTO itemsDTO) {
        return ReturnMsg.ok(baseService.findList(itemsDTO));
    }

    @Override
    protected void beforeSave(ItemsDTO entity) throws Exception {
        entity.setCreateTime(new Date());
        super.beforeSave(entity);
    }

}

