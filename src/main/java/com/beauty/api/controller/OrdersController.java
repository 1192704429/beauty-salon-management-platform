package com.beauty.api.controller;

import cn.hutool.core.collection.CollectionUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.beauty.api.common.BaseController;
import com.beauty.api.common.BaseSelectEntity;
import com.beauty.api.common.ReturnMsg;
import com.beauty.api.dto.*;
import com.beauty.api.entity.Items;
import com.beauty.api.entity.ProjectItem;
import com.beauty.api.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @description: 美容订单对外接口层
 * @author: beautyAuthor
 * @create: 2024.11.13 11:28:25
 */
@RestController
@RequestMapping("/orders")
public class OrdersController extends BaseController<OrdersService, OrdersDTO> {

    @Autowired
    private UserService userService;
    @Autowired
    private BeautyProjectsService beautyProjectsService;
    @Autowired
    private BeauticianService beauticianService;

    @Autowired
    private ProjectItemService projectItemService;

    @Autowired
    private ItemsService itemsService;

    @Override
    @Resource(name = "ordersService")
    protected void setBaseService(OrdersService ordersService) {
        this.baseService = ordersService;
    }

    /**
     * 默认分页查询
     *
     * @param ordersDTO
     * @return
     */
    @PostMapping("/page")
    public ReturnMsg page(@RequestBody OrdersDTO ordersDTO) {
        return ReturnMsg.ok(baseService.basePage(ordersDTO));
    }

    /**
     * 根据XML中的sql语句进行查询
     *
     * @param ordersDTO
     * @return
     */
    @PostMapping(value = "/findList")
    public ReturnMsg findList(@RequestBody OrdersDTO ordersDTO) {
        return ReturnMsg.ok(baseService.findList(ordersDTO));
    }

    @Override
    protected void beforeSave(OrdersDTO entity) throws Exception {
        entity.setCreateTime(new Date());
        super.beforeSave(entity);
    }


    @Override
    protected void beforeUpdate(OrdersDTO entity) throws Exception {
        Long beauticianId = entity.getBeauticianId();
        BeauticianDTO beauticianDTO = beauticianService.getById(beauticianId);
        // 服务开始
        if (entity.getStatus() == 3) {
            beauticianDTO.setStatus(2);
            // 检查库存是否足够
            Long projectId = entity.getProjectId();
            LambdaQueryWrapper<ProjectItemDTO> queryWrapper = new LambdaQueryWrapper<>();
            queryWrapper.eq(ProjectItemDTO::getProjectId, projectId);
            List<ProjectItemDTO> projectItemDTOS = projectItemService.list(queryWrapper);
            if (CollectionUtil.isNotEmpty(projectItemDTOS)) {
                List<Long> itemIds = projectItemDTOS.stream().map(ProjectItem::getItemId).collect(Collectors.toList());
                List<ItemsDTO> itemsDTOS = itemsService.listByIds(itemIds);
                Map<Long, ItemsDTO> stringMap = itemsDTOS.stream().collect(Collectors.toMap(Items::getId, item -> item, (k1, k2) -> k1));
                List<ItemsDTO> updateDto = new ArrayList<>();
                for (ProjectItemDTO projectItemDTO : projectItemDTOS) {
                    ItemsDTO dto = stringMap.get(projectItemDTO.getItemId());
                    if (dto == null) {
                        throw new Exception("配置有误，未发现美容物品，物品编号为" + projectItemDTO.getItemId());
                    }
                    if (dto.getStock() < projectItemDTO.getNum()) {
                        throw new Exception("物品" + dto.getName() + "库存不足");
                    }
                    // 削减库存
                    dto.setStock(dto.getStock() - projectItemDTO.getNum());
                    updateDto.add(dto);
                }
                itemsService.updateBatchById(updateDto);
            } else {
                throw new Exception("当前服务项目尚未配置消耗产品，请联系管理员");
            }
        } else if (entity.getStatus() == 4) {
            beauticianDTO.setStatus(1);
            entity.setEndTime(new Date());
        }
        beauticianService.updateById(beauticianDTO);
        super.beforeUpdate(entity);
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

    @GetMapping("/all/beautician")
    public ReturnMsg allBeautician() {
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

}

