package com.beauty.api.controller;

import com.beauty.api.common.BaseController;
import com.beauty.api.common.ReturnMsg;
import com.beauty.api.dto.BannerDTO;
import com.beauty.api.service.BannerService;
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
* @description: 轮播图管理对外接口层
* @author: beautyAuthor
* @create: 2024.11.13 11:28:25
*/
@RestController
@RequestMapping("/banner")
public class BannerController extends BaseController<BannerService, BannerDTO> {


    @Override
    @Resource(name = "bannerService")
    protected void setBaseService(BannerService bannerService) {
        this.baseService = bannerService;
    }

    /**
    * 默认分页查询
    * @param bannerDTO
    * @return
    */
    @PostMapping("/page")
    public ReturnMsg page(@RequestBody BannerDTO bannerDTO) {
        return ReturnMsg.ok(baseService.basePage(bannerDTO));
    }

    /**
    * 根据XML中的sql语句进行查询
    * @param bannerDTO
    * @return
    */
    @PostMapping(value = "/findList")
    public ReturnMsg findList(@RequestBody BannerDTO bannerDTO) {
        return ReturnMsg.ok(baseService.findList(bannerDTO));
    }

    @Override
    protected void beforeSave(BannerDTO entity) throws Exception {
        entity.setCreateTime(new Date());
        super.beforeSave(entity);
    }

}

