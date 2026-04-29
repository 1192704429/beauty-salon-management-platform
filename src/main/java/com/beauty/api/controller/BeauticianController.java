package com.beauty.api.controller;

import com.beauty.api.common.BaseController;
import com.beauty.api.common.ReturnMsg;
import com.beauty.api.dto.BeauticianDTO;
import com.beauty.api.service.BeauticianService;
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
* @description: 美容师管理对外接口层
* @author: beautyAuthor
* @create: 2024.11.13 11:28:25
*/
@RestController
@RequestMapping("/beautician")
public class BeauticianController extends BaseController<BeauticianService, BeauticianDTO> {


    @Override
    @Resource(name = "beauticianService")
    protected void setBaseService(BeauticianService beauticianService) {
        this.baseService = beauticianService;
    }

    /**
    * 默认分页查询
    * @param beauticianDTO
    * @return
    */
    @PostMapping("/page")
    public ReturnMsg page(@RequestBody BeauticianDTO beauticianDTO) {
        return ReturnMsg.ok(baseService.basePage(beauticianDTO));
    }

    /**
    * 根据XML中的sql语句进行查询
    * @param beauticianDTO
    * @return
    */
    @PostMapping(value = "/findList")
    public ReturnMsg findList(@RequestBody BeauticianDTO beauticianDTO) {
        return ReturnMsg.ok(baseService.findList(beauticianDTO));
    }

    @Override
    protected void beforeSave(BeauticianDTO entity) throws Exception {
        entity.setCreateTime(new Date());
        super.beforeSave(entity);
    }
}

