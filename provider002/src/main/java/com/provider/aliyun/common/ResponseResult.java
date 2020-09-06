package com.provider.aliyun.common;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.Data;

import java.io.Serializable;

/**
 * @author lilili
 * @version 0.0.1
 * @date 2020/8/26 4:20 下午
 */
@Data
public class ResponseResult<T> implements Serializable {

    private String code = "0001";

    private String message = "success";

    private T data;

}

@Data
class UserBean implements Serializable {

    private String name;

    private String age;

}

class Test {
    public static void main(String[] args) {
        new JSONObject();
        System.out.println(JSON.toJSONString(testResponseResult()));
        System.out.println(JSON.toJSONString(testResponseResultString()));
    }

    public static ResponseResult<UserBean> testResponseResult() {
        ResponseResult<UserBean> result= new ResponseResult<>();
        UserBean userBean = new UserBean();
        userBean.setAge("18");
        userBean.setName("li");
        result.setData(userBean);
        result.setCode("0002");
        return result;
    }
    public static ResponseResult<String> testResponseResultString() {
        ResponseResult<String> result= new ResponseResult<>();
        UserBean userBean = new UserBean();
        userBean.setAge("18");
        userBean.setName("li");
        result.setData("data");
        return result;
    }
}
