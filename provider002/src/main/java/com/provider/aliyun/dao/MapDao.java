package com.provider.aliyun.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author lilili
 * @version 0.0.1
 * @date 2020/8/27 11:00 上午
 */
@Repository
public interface MapDao {
    /**
     * 通过id获取地图某个名称
     *
     * @param id 标识
     * @return 名称
     */
    String selectMapById(@Param("id") String id);

}
