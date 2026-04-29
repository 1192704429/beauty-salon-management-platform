package com.beauty.api.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.beauty.api.dao.UserDao;
import com.beauty.api.dto.DataDTO;
import com.beauty.api.dto.UserDTO;
import com.beauty.api.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

/**
* @description: 用户管理业务层实现类
* @author: beautyAuthor
* @create: 2024.11.13 11:28:25
*/
@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserDao, UserDTO> implements UserService {

    @Override
    public Page<UserDTO> basePage(UserDTO userDTO) {
        if (null != userDTO.getCurrent() && null != userDTO.getPageSize())
            userDTO.setCurrent((userDTO.getCurrent() - 1) * userDTO.getPageSize());
        List<UserDTO> list = this.baseMapper.findList(userDTO);
        int count = this.baseMapper.findPageCount(userDTO);
        Page<UserDTO> page = new Page<>();
        page.setTotal(count);
        page.setRecords(list);
        return page;
    }

    @Override
    public List<UserDTO> findList(UserDTO userDTO) {
        return this.baseMapper.findList(userDTO);
    }

    @Override
    public List<DataDTO> getNumBySex() {

        return  this.baseMapper.getNumBySex();
    }

}
