package com.imooc.controller;

import com.imooc.utils.RedisOperator;
import javax.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

@ApiIgnore
@RestController
@RequestMapping("redis")
public class RedisController {

    @Resource
    private RedisOperator redisOperator;

    @GetMapping("set")
    public Object set(String key, String value){
        redisOperator.set(key, value);
        return "OK";
    }

    @GetMapping("get")
    public String get(String key){
        return redisOperator.get(key);
    }

    @GetMapping("delete")
    public Object delete(String key){
        redisOperator.del(key);
        return "OK";
    }

}
