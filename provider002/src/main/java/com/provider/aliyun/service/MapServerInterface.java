package com.provider.aliyun.service;

import com.provider.aliyun.common.ResponseResult;

/**
 * @author lilili
 * @version 0.0.1
 * @date 2020/8/27 10:53 上午
 */
public interface MapServerInterface {
    /**
     * 通过id获取地图某个名称
     *
     * @param id 标识
     * @return 名称
     */
    ResponseResult<String> findMapById(String id);

}
