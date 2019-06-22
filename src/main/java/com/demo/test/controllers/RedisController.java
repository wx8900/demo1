package com.demo.test.controllers;

import com.demo.test.domain.Constant;
import com.demo.test.domain.ResultInfo;
import com.demo.test.domain.Student;
import com.demo.test.utils.RedisUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/v1/api/students")
@Slf4j
public class RedisController {

    Logger logger = Logger.getLogger(RedisController.class);

    /*@Autowired
    private RedisUtils redisUtils;*/
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @PostMapping(value="/redisAdd")
    public void saveRedis(){
        stringRedisTemplate.opsForValue().set("admin2019062211","test062211");
    }

    @GetMapping(value="/redisGet")
    public String getRedis(){
        return stringRedisTemplate.opsForValue().get("admin2019062211");
    }

    /**
     * 添加用户
     */
    @PostMapping("/redis/add")
    public ResultInfo addUser(@Valid @RequestBody Student student) throws Exception {
        stringRedisTemplate.opsForValue().set("uUserTest0622", student.toString());
        logger.info("redis保存数据为：[{}]" + student.toString());
        return new ResultInfo(Constant.SUCCESS, "Redis保存数据成功！");
    }

    /**
     * 获取用户
     */
    @GetMapping("/redis/get")
    public ResultInfo getUser() throws Exception {
        Object uu = stringRedisTemplate.opsForValue().get("uUserTest0622");
        logger.info("redis中获取数据：[{}]" + uu);
        logger.error("redis中获取数据：[{}]" + uu);
        logger.warn("redis中获取数据：[{}]" + uu);
        logger.debug("redis中获取数据：[{}]" + uu);
        return new ResultInfo(Constant.SUCCESS, "Redis查询数据成功！");
    }

}