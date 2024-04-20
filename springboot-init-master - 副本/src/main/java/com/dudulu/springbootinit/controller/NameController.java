package com.dudulu.springbootinit.controller;

import com.dudulu.yuapiclientsdk.model.User;
import com.dudulu.yuapiclientsdk.utils.SignUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @program: SecKill_my
 * @description: 测试名称接口
 * @author: Dudulu
 * @create: 2024-03-19 19:27
 **/
@RestController
@RequestMapping("/name")
public class NameController {

    @GetMapping("/get")
    public String getNameByGET(String name, HttpServletRequest request) {
        return "GET 你的名字是:" + name;
    }

    @PostMapping("/post")
    public String getNameByPost(@RequestParam String name) {
        return "POST 你的名字是:" + name;
    }

    @PostMapping("/user")
    public String getUserNameByPost(@RequestBody User user, HttpServletRequest request) {
        String accessKey = request.getHeader("accessKey");
        String nonce = request.getHeader("nonce");
        String timestamp = request.getHeader("timestamp");
        String body = request.getHeader("body");
        String sign = request.getHeader("sign");
//        String secretKey = request.getHeader("secretKey");
        // 理论上应该是读取数据库拿到accesskey
        if(!accessKey.equals("dudulu")){
            throw new RuntimeException("无权限");
        }
        if (Long.parseLong(nonce) > 10000) {
            throw new RuntimeException("无权限");
        }
//        if (timestamp) 不超过5分钟
        String serverSign = SignUtils.genSign(body, "abcdefgh");// 理论上应该是从数据库查到给用户发放的key
        if (!sign.equals(serverSign)) {
            throw new RuntimeException("无权限");
        }
        return "POST 你的名字是:" + user.getUsername();
    }
}
