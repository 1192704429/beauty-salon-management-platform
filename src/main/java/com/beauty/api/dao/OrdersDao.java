package com.beauty.api.dao;

import com.beauty.api.common.BaseDao;
import com.beauty.api.dto.DataDTO;
import com.beauty.api.dto.OrdersDTO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
* @description: 美容订单持久层
* @author: beautyAuthor
* @create: 2024.11.13 11:28:25
*/
public interface OrdersDao extends BaseDao<OrdersDTO> {

    @Select("select project_id,count(*) as num from orders group by project_id order by num desc limit #{num}")
    List<OrdersDTO> selectProjectCount(Integer num);

    @Select("\n" +
            "SELECT DATE(create_time) AS name, SUM(CAST(money AS DECIMAL(10,2))) AS value\n" +
            "FROM orders\n" +
            "WHERE status != 0 and  `status` != 5\n" +
            "AND create_time >= NOW() - INTERVAL #{num} DAY\n" +
            "GROUP BY DATE(create_time)\n" +
            "ORDER BY name;\n")
    List<DataDTO> getMoneyNum(@Param("num") int num);

    @Select("select b.title as name , project_id ,count(*) value  from orders o left join beauty_projects b on b.id = o.project_id group by project_id")
    List<DataDTO> getProjectCount();
}
