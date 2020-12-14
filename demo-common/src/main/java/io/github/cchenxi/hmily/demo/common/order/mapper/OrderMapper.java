package io.github.cchenxi.hmily.demo.common.order.mapper;

import io.github.cchenxi.hmily.demo.common.order.entity.Order;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;

/**
 * Date: 2020-12-13
 *
 * @author chenxi
 */
public interface OrderMapper {
    @Insert("insert into `order` (create_time,number,status,product_id,total_amount,count,user_id) " +
            " values ( #{createTime},#{number},#{status},#{productId},#{totalAmount},#{count},#{userId})")
    int save(Order order);

    @Update("update `order` set status = #{status} where number = #{number}")
    int update(Order order);
}
