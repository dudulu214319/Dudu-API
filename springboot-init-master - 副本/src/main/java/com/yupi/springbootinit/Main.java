package com.yupi.springbootinit;

import com.yupi.yuapiclientsdk.client.YuApiClient;
import com.yupi.yuapiclientsdk.model.User;

/**
 * @program: springboot-init-master - 副本
 * @description: main
 * @author: Mr.Wang
 * @create: 2024-03-19 21:37
 **/
public class Main {
    public static void main(String[] args) {
        String accessKey = "yupi";
        String secretKey = "abcdefgh";
        YuApiClient yuApiClient = new YuApiClient(accessKey, secretKey); // 分发密钥
        String result1 = yuApiClient.getNameByGET("嘟嘟噜");
        String result2 = yuApiClient.getNameByPost("都宝");
        User user = new User();
        user.setUsername("dudu");
        String result3 = yuApiClient.getUserNameByPost(user);
        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);
    }
}
