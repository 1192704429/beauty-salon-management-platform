package com.beauty.api.dao;

import com.beauty.api.common.BaseDao;
import com.beauty.api.dto.DataDTO;
import com.beauty.api.dto.UserDTO;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
* @description: 用户管理持久层
* @author: beautyAuthor
* @create: 2024.11.13 11:28:25
*/
public interface UserDao extends BaseDao<UserDTO> {

    @Select("select CASE sex  WHEN 0 THEN '女'  WHEN 1 THEN '男'  END AS name,count(*) as value from user where sex is not null group by sex;")
    List<DataDTO> getNumBySex();


}
