package com.yupi.yuapiclientsdk;

import com.yupi.yuapiclientsdk.client.YuApiClient;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @program: yuapi-client-sdk
 * @description: 配置
 * @author: Mr.Wang
 * @create: 2024-03-21 10:56
 **/
@Configuration
@ConfigurationProperties("yuapi.client")
@Data
@ComponentScan
public class YuApiClientConfig {
    private String accessKey;
    private String secretKey;

    @Bean
    public YuApiClient yuApiClient() {
        return new YuApiClient(accessKey, secretKey); // 激活客户端需要输入访问码和发布的密钥
    }
}
