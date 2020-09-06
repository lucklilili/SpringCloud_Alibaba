package com.consumer.aliyun.service.impl;

import com.consumer.aliyun.common.ResponseResult;
import com.consumer.aliyun.service.ProviderFeign;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author lilili
 * @version 0.0.1
 * @date 2020/8/27 10:54 上午
 */
@Slf4j
@Service
public class ProviderFeignImpl {

    @Resource
    private ProviderFeign providerFeign;

    public ResponseResult<String> findMapById(String id){
        return providerFeign.findMapById(id);
    }


}
