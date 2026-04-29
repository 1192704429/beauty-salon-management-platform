package com.beauty.api.controller;

import com.beauty.api.common.BaseController;
import com.beauty.api.common.ReturnMsg;
import com.beauty.api.dto.AdminsDTO;
import com.beauty.api.dto.DataDTO;
import com.beauty.api.dto.UserDTO;
import com.beauty.api.service.AdminsService;
import com.beauty.api.service.OrdersService;
import com.beauty.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * @description: 管理员管理对外接口层
 * @author: beautyAuthor
 * @create: 2024.11.13 11:28:25
 */
@RestController
@RequestMapping("/admins")
public class AdminsController extends BaseController<AdminsService, AdminsDTO> {

    @Autowired
    private UserService userService;

    @Autowired
    private OrdersService ordersService;

    @Override
    @Resource(name = "adminsService")
    protected void setBaseService(AdminsService adminsService) {
        this.baseService = adminsService;
    }

    @GetMapping("/echarts/{day}")
    public ReturnMsg echarts(@PathVariable Integer day) {
        // 客户男女数量
        List<DataDTO> sexNum = userService.getNumBySex();
        // 年龄统计
        List<UserDTO> allUser = userService.list();
        int a1 = 0, a2 = 0, a3 = 0, a4 = 0, a5 = 0, a6 = 0, a7 = 0;
        for (UserDTO userDTO : allUser) {
            Integer age = userDTO.getAge();
            if (age == null) continue;
            if (age > 0 && age <= 10) {
                a1++;
            }
            if (age > 10 && age <= 20) {
                a2++;
            }
            if (age > 20 && age <= 30) {
                a3++;
            }
            if (age > 30 && age <= 40) {
                a4++;
            }
            if (age > 40 && age <= 50) {
                a5++;
            }
            if (age > 50 && age <= 60) {
                a6++;
            }
            if (age > 60) {
                a7++;
            }
        }
        List<DataDTO> ageDto = new ArrayList<>();
        DataDTO dataDTO = new DataDTO("0-10", a1);
        ageDto.add(dataDTO);
        DataDTO dataDTO1 = new DataDTO("10-20", a2);
        ageDto.add(dataDTO1);
        DataDTO dataDTO2 = new DataDTO("20-30", a3);
        ageDto.add(dataDTO2);
        DataDTO dataDTO3 = new DataDTO("30-40", a4);
        ageDto.add(dataDTO3);
        DataDTO dataDTO4 = new DataDTO("40-50", a5);
        ageDto.add(dataDTO4);
        DataDTO dataDTO5 = new DataDTO("50-60", a6);
        ageDto.add(dataDTO5);
        DataDTO dataDTO6 = new DataDTO("70+", a7);
        ageDto.add(dataDTO6);
        // 最近七天营业额
        List<DataDTO> orderData = ordersService.getMoneyNum(day);
        // 不同项目下单数量
        List<DataDTO> projectData = ordersService.getProjectCount();
        HashMap<Object, Object> hashMap = new HashMap<>();
        hashMap.put("age", ageDto);
        hashMap.put("projectCount", projectData);
        hashMap.put("orderData", orderData);
        hashMap.put("sexNum", sexNum);
        return ReturnMsg.ok(hashMap);
    }

    /**
     * 默认分页查询
     *
     * @param adminsDTO
     * @return
     */
    @PostMapping("/page")
    public ReturnMsg page(@RequestBody AdminsDTO adminsDTO) {
        return ReturnMsg.ok(baseService.basePage(adminsDTO));
    }

    /**
     * 根据XML中的sql语句进行查询
     *
     * @param adminsDTO
     * @return
     */
    @PostMapping(value = "/findList")
    public ReturnMsg findList(@RequestBody AdminsDTO adminsDTO) {
        return ReturnMsg.ok(baseService.findList(adminsDTO));
    }

    @Override
    protected void beforeSave(AdminsDTO entity) throws Exception {
        entity.setCreateTime(new Date());
        super.beforeSave(entity);
    }

}

