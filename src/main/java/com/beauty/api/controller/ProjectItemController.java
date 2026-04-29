package com.beauty.api.controller;

import com.beauty.api.common.BaseController;
import com.beauty.api.common.ReturnMsg;
import com.beauty.api.dto.ProjectItemDTO;
import com.beauty.api.service.ProjectItemService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import com.beauty.api.common.BaseSelectEntity;
import java.util.ArrayList;
import com.beauty.api.service.BeautyProjectsService;
import com.beauty.api.dto.BeautyProjectsDTO;
import com.beauty.api.service.ItemsService;
import com.beauty.api.dto.ItemsDTO;
import javax.annotation.Resource;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.util.List;
import com.beauty.api.common.BaseSelectEntity;
import cn.hutool.core.collection.CollectionUtil;
import java.util.Date;
/**
* @description: 项目消耗对外接口层
* @author: beautyAuthor
* @create: 2024.11.13 11:28:25
*/
@RestController
@RequestMapping("/projectItem")
public class ProjectItemController extends BaseController<ProjectItemService, ProjectItemDTO> {

    @Autowired
    private BeautyProjectsService beautyProjectsService;
    @Autowired
    private ItemsService itemsService;

    @Override
    @Resource(name = "projectItemService")
    protected void setBaseService(ProjectItemService projectItemService) {
        this.baseService = projectItemService;
    }

    /**
    * 默认分页查询
    * @param projectItemDTO
    * @return
    */
    @PostMapping("/page")
    public ReturnMsg page(@RequestBody ProjectItemDTO projectItemDTO) {
        return ReturnMsg.ok(baseService.basePage(projectItemDTO));
    }

    /**
    * 根据XML中的sql语句进行查询
    * @param projectItemDTO
    * @return
    */
    @PostMapping(value = "/findList")
    public ReturnMsg findList(@RequestBody ProjectItemDTO projectItemDTO) {
        return ReturnMsg.ok(baseService.findList(projectItemDTO));
    }

    @Override
    protected void beforeSave(ProjectItemDTO entity) throws Exception {
        entity.setCreateTime(new Date());
        super.beforeSave(entity);
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

    @GetMapping("/all/items")
    public ReturnMsg allItems() {
        List<BaseSelectEntity> list = new ArrayList<>();
        List<ItemsDTO> dtos = itemsService.list();
            for (ItemsDTO dto : dtos) {
            BaseSelectEntity baseSelectEntity = new BaseSelectEntity();
            baseSelectEntity.setKey(dto.getId());
            baseSelectEntity.setValue(dto.getName());
            list.add(baseSelectEntity);
        }
        return ReturnMsg.ok(list);
    }

}

