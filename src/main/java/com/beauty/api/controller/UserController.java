package com.beauty.api.controller;

import cn.hutool.core.collection.CollectionUtil;
import com.beauty.api.common.BaseController;
import com.beauty.api.common.ReturnMsg;
import com.beauty.api.dto.UserDTO;
import com.beauty.api.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @description: 用户管理对外接口层
 * @author: beautyAuthor
 * @create: 2024.11.13 11:28:25
 */
@RestController
@RequestMapping("/user")
public class UserController extends BaseController<UserService, UserDTO> {


    @Override
    @Resource(name = "userService")
    protected void setBaseService(UserService userService) {
        this.baseService = userService;
    }

    /**
     * 默认分页查询
     *
     * @param userDTO
     * @return
     */
    @PostMapping("/page")
    public ReturnMsg page(@RequestBody UserDTO userDTO) {
        return ReturnMsg.ok(baseService.basePage(userDTO));
    }

    /**
     * 根据XML中的sql语句进行查询
     *
     * @param userDTO
     * @return
     */
    @PostMapping(value = "/findList")
    public ReturnMsg findList(@RequestBody UserDTO userDTO) {
        return ReturnMsg.ok(baseService.findList(userDTO));
    }

    @Override
    protected void beforeSave(UserDTO entity) throws Exception {
        entity.setCreateTime(new Date());
        super.beforeSave(entity);
    }

    @PostMapping(value = "/login")
    public ReturnMsg login(@RequestBody UserDTO foodUserDTO) throws Exception {
        List<UserDTO> list = baseService.findList(foodUserDTO);
        if (CollectionUtil.isEmpty(list)) throw new Exception("账号或密码有误");
        return ReturnMsg.ok(list.get(0));
    }

    @PostMapping(value = "/register")
    public ReturnMsg register(@RequestBody UserDTO foodUserDTO) throws Exception {
        UserDTO foodUserDTO1 = new UserDTO();
        foodUserDTO1.setUsername(foodUserDTO.getUsername());
        List<UserDTO> list = baseService.findList(foodUserDTO1);
        if (CollectionUtil.isNotEmpty(list)) throw new Exception("账号已被占用");
        foodUserDTO.setNickName("顾客-" + foodUserDTO.getUsername());
        foodUserDTO.setCreateTime(new Date());
        foodUserDTO.setAvatar("https://code-graden-server-dev.oss-cn-beijing.aliyuncs.com/2022-05-09/f2623747-22cd-4faa-8c37-bf53f88fe34d_2.png");
        this.baseService.save(foodUserDTO);
        return ReturnMsg.ok();
    }

}

