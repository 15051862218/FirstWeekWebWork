package com.example.day05.entity;


import com.alibaba.fastjson.JSON;
import com.entity.User;

/**
 * @Author 沈永康
 * @Date 2022/3/2 15:06
 * @Version 1.0
 */


public class FastJsonDemo {
    public static void main(String[] args) {
        User user =new User();
        user.setId(1);
        user.setUsername("zhangsan");
        user.setPassword("123");
        String jsonStr= JSON.toJSONString(user);
        System.out.println(jsonStr);
        User user1=JSON.parseObject("{\"id\": 1,\"password\": \"123\",\"username\": \"zhangsan\"}",User.class);
        System.out.println(user1);
    }
}
