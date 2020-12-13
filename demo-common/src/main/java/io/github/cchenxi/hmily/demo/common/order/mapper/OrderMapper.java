package io.github.cchenxi.hmily.demo.common.order.mapper;

import org.apache.ibatis.annotations.Insert;

/**
 * TODO: description
 * Date: 2020-12-13
 *
 * @author chenxi
 */

public interface OrderMapper {
    @Insert("")
    int save();
}
