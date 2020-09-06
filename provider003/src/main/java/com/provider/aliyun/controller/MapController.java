package com.provider.aliyun.controller;

import com.provider.aliyun.common.ResponseResult;
import com.provider.aliyun.service.MapServerInterface;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author lilili
 * @version 0.0.1
 * @date 2020/8/26 6:03 下午
 */
@RestController
public class MapController {

    @Resource
    private MapServerInterface mapServerInterface;

    @RequestMapping(value = "/findMap", method = RequestMethod.POST)
    public ResponseResult<String> mapServerInterface(@RequestBody String id) {
        return mapServerInterface.findMapById(id);
    }
}
