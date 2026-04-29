package com.beauty.api.controller;

import com.beauty.api.common.BaseController;
import com.beauty.api.common.ReturnMsg;
import com.beauty.api.dto.NewsDTO;
import com.beauty.api.service.NewsService;
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
* @description: 新闻资讯对外接口层
* @author: beautyAuthor
* @create: 2024.11.13 11:28:25
*/
@RestController
@RequestMapping("/news")
public class NewsController extends BaseController<NewsService, NewsDTO> {


    @Override
    @Resource(name = "newsService")
    protected void setBaseService(NewsService newsService) {
        this.baseService = newsService;
    }

    /**
    * 默认分页查询
    * @param newsDTO
    * @return
    */
    @PostMapping("/page")
    public ReturnMsg page(@RequestBody NewsDTO newsDTO) {
        return ReturnMsg.ok(baseService.basePage(newsDTO));
    }

    /**
    * 根据XML中的sql语句进行查询
    * @param newsDTO
    * @return
    */
    @PostMapping(value = "/findList")
    public ReturnMsg findList(@RequestBody NewsDTO newsDTO) {
        return ReturnMsg.ok(baseService.findList(newsDTO));
    }

    @Override
    protected void beforeSave(NewsDTO entity) throws Exception {
        entity.setCreateTime(new Date());
        super.beforeSave(entity);
    }

}

