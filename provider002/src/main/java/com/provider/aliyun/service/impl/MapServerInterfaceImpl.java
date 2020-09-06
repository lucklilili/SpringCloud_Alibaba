package com.provider.aliyun.service.impl;

import com.provider.aliyun.common.ResponseResult;
import com.provider.aliyun.dao.MapDao;
import com.provider.aliyun.service.MapServerInterface;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author lilili
 * @version 0.0.1
 * @date 2020/8/27 10:54 上午
 */
@Slf4j
@Service
public class MapServerInterfaceImpl implements MapServerInterface {

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private MapDao mapDao;

    @Override
    public ResponseResult<String> findMapById(String id) {
        ResponseResult<String> responseResult = new ResponseResult<>();
        responseResult.setData(mapDao.selectMapById(id) + " \t " + serverPort);
        return responseResult;
    }
}
