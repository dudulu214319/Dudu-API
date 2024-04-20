package com.dudulu.springbootinit;

import com.dudulu.springbootinit.config.WxOpenConfig;
import javax.annotation.Resource;

import com.dudulu.yuapiclientsdk.client.YuApiClient;
import com.dudulu.yuapiclientsdk.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * 主类测试
 *
 * @author <a href="https://github.com/lidudulu"></a>
 * @from <a href="https://dudulu.icu"></a>
 */
@SpringBootTest
class MainApplicationTests {

    @Resource
    private YuApiClient yuApiClient;

    @Test
    void contextLoads() {
        User user = new User();
        user.setUsername("dudu");
        String userNameByPost = yuApiClient.getUserNameByPost(user); // 使用sdk中的yuApiClient访问服务端的接口？端口？SDK里写死了
        //HttpRequest.post("http://localhost:8123/api/name/user")
    }
}
