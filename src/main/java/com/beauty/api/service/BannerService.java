package com.beauty.api.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.beauty.api.dto.BannerDTO;
import java.util.List;
/**
* @description: 轮播图管理业务层接口
* @author: beautyAuthor
* @create: 2024.11.13 11:28:25
*/
public interface BannerService extends IService<BannerDTO> {

    /**
    * 默认分页方法
    * @param bannerDTO
    * @return
    */
    Page<BannerDTO> basePage(BannerDTO bannerDTO);


    /**
    * 根据XML中的sql语句进行查询
    * @param bannerDTO
    * @return
    */
    List<BannerDTO> findList(BannerDTO bannerDTO);

}
