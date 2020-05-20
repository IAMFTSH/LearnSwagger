package com.learn.swagger.controller;

import com.learn.swagger.pojo.User;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class HelloController {
/*    @ApiOperation("请求注释")
    @ResponseBody
    @RequestMapping("Hello")  //*******如果使用RequestMapping会有很多个显示出来，除非你使用GetMapping等或者增加method参数*******
    public String hello(){
        return "测试返回值";
    }*/


    @ResponseBody
    @GetMapping("user/Hello")
    public String userHello(){
        return "测试过滤";
    }

    @ApiOperation("post带参请求")
    @ResponseBody
    @PostMapping("user/paramByPost")
    public String paramByPost(@ApiParam("用户名") String username){
        System.out.println(username);
        return "测试带参";
    }

    @ApiOperation("get带参请求")
    @ApiImplicitParam(name = "username", value = "用户名", paramType = "query", dataType = "String", required = true)
    @ResponseBody
    @GetMapping(value = "user/paramByGet")
    public String paramByGet(String username){
        System.out.println(username);
        return "测试带参"+username;
    }

    @ApiOperation("pojoParamByPost带参请求")
    @ResponseBody
    @PostMapping("user/pojoParamByPost")   //如果使用RequestMapping会有很多个显示出来，除非你使用GetMapping或者增加method参数
    public User pojoParamByPost(@ApiParam("用户")  User user){
        return user;
    }

    @ApiOperation("pojoParamByPost带参请求")
    @ResponseBody
    @PostMapping("user/pojoParamByPostAndParamType")   //如果使用RequestMapping会有很多个显示出来，除非你使用GetMapping或者增加method参数
    public User pojoParamByPostAndParamType(User user){
        return user;
    }
//paramType：参数放在哪个地方       **********************************未解之密
//header-->请求参数的获取：@RequestHeader
//query-->请求参数的获取：@RequestParam
//path（用于restful接口）-->请求参数的获取：@PathVariable
//body（不常用）
//form（不常用）

    @PostMapping  //必须要有@Data标签   可能需要get/set 或者相应的构造方法   具体哪个不知
    public User user(){
        return new User();
    }
}
