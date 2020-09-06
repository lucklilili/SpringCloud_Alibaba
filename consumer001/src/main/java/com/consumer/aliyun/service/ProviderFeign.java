package com.consumer.aliyun.service;

import com.consumer.aliyun.common.ResponseResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author lilili
 * @version 0.0.1
 * @date 2020/8/27 10:53 上午
 */
@FeignClient(value = "provider", fallback = ProviderFeignFallback.class)
public interface ProviderFeign {
    /**
     * 通过id获取地图某个名称
     *
     * @param id 标识
     * @return 名称
     */
    @RequestMapping(value = "/findMap")
    ResponseResult<String> findMapById(String id);

}

class ProviderFeignFallback implements ProviderFeign{
    @Override
    public ResponseResult<String> findMapById(String id) {
        ResponseResult<String> fallback = new ResponseResult<>();
        fallback.setCode("100001");
        fallback.setMessage("ProviderFeignFallback");
        fallback.setData("error");
        return fallback;
    }
}


