package com.beauty.api.controller;

import cn.hutool.core.lang.UUID;
import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.beauty.api.common.ReturnMsg;
import com.beauty.api.dto.AdminsDTO;
import com.beauty.api.dto.BeauticianDTO;
import com.beauty.api.service.AdminsService;
import com.beauty.api.service.BeauticianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @description: 后台管理登录控制器
 * @author: beautyAuthor
 * @Create: 2024.11.13 11:28:25
 */
@RestController
@RequestMapping("/manage/login")
public class LoginController {

    static Map<String, String> userInfoMap = new HashMap<>();

    @Autowired
    private AdminsService adminsService;

    @Autowired
    private BeauticianService beauticianService;

    @PostMapping
    public ReturnMsg manageLogin(@RequestBody Map<String, String> param) {
        if (StrUtil.isEmpty(param.get("username")) || StrUtil.isEmpty(param.get("password"))) {
            return ReturnMsg.error("用户名或密码错误!");
        }
        String typeStr = param.get("type").toString();
        int type = Integer.parseInt(typeStr);
        Map<String, Object> map = new HashMap<>();
        map.put("type", type);
        Map<String, String> returnMap = new HashMap<>();
        returnMap.put("type", typeStr);
        if (type == 0) {
            AdminsDTO adminsDTO = new AdminsDTO();
            adminsDTO.setUsername(param.get("username"));
            adminsDTO.setPassword(param.get("password"));
            QueryWrapper<AdminsDTO> adminsDTOQueryWrapper = new QueryWrapper<>(adminsDTO);
            adminsDTOQueryWrapper.last("limit 1");
            AdminsDTO adminDTOS = adminsService.getOne(adminsDTOQueryWrapper);
            if (adminDTOS == null) return ReturnMsg.error("用户名或密码错误!");
            map.put("avatar", StrUtil.isNotBlank(adminDTOS.getHeadImg()) ? adminDTOS.getHeadImg() : "https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
            map.put("introduction", adminDTOS.getName() + ",你好!");
            map.put("name", adminDTOS.getName());
            map.put("id", adminDTOS.getId());
        } else {
            BeauticianDTO beauticianDTO = new BeauticianDTO();
            beauticianDTO.setUsername(param.get("username"));
            beauticianDTO.setPassword(param.get("password"));
            QueryWrapper<BeauticianDTO> beauticianDTOQueryWrapper = new QueryWrapper<>(beauticianDTO);
            beauticianDTOQueryWrapper.last("limit 1");
            BeauticianDTO beauticianDTO1 = beauticianService.getOne(beauticianDTOQueryWrapper);
            if (beauticianDTO1 == null) return ReturnMsg.error("用户名或密码错误!");
            map.put("avatar", StrUtil.isNotBlank(beauticianDTO1.getAvatar()) ? beauticianDTO1.getAvatar() : "https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
            map.put("introduction", beauticianDTO1.getName() + ",你好!");
            map.put("name", beauticianDTO1.getName());
            map.put("id", beauticianDTO1.getId());
        }
        map.put("roles", Arrays.asList("admin"));
        String uuid = UUID.randomUUID().toString();
        returnMap.put("token", uuid);
        userInfoMap.put(uuid, JSON.toJSONString(map));
        return ReturnMsg.ok(returnMap);
    }

    @GetMapping
    public ReturnMsg getUserInfo(@RequestParam("token") String token) {
        if (!userInfoMap.containsKey(token)) return ReturnMsg.error(401, "尚未登录,请重新登录!");
        return ReturnMsg.ok(JSON.parse(userInfoMap.get(token)));
    }

    @GetMapping("/logout")
    public ReturnMsg logout(@RequestParam("token") String token) {
        userInfoMap.remove(token);
        return ReturnMsg.ok();
    }

}
