package com.demo.test.controllers;

import com.demo.test.exception.ApiErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 全局异常处理测试类
 *
 * @author Jack
 * @date   2019/07/16
 */
@RestController
public class GlobalExceptionControllerTest {

    /**
     * 测试myExceptionHandler异常
     *
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/myException")
    public String index() throws Exception{
        throw new ApiErrorResponse(HttpStatus.BAD_REQUEST,"empty"
                ,"/API/getUserName","在获取用户名字的时候为空");
    }

    /**
     * 测试GlobalExceptionHandler异常
     *
     * @param id
     * @return
     */
    @RequestMapping("/{id}")
    public String test(@PathVariable Integer id){
        if (true) {
            id = 1/id;
        }
        return "success";
    }
}
