package com.dudulu.yuapiclientsdk.utils;

import cn.hutool.crypto.digest.DigestAlgorithm;
import cn.hutool.crypto.digest.Digester;

/**
 * @program: springboot-init-master - 副本
 * @description: 生成签名
 * @author: Dudulu
 * @create: 2024-03-20 21:12
 **/
public class SignUtils {
    public static String genSign(String body, String secretKey) {
        Digester md5 = new Digester(DigestAlgorithm.SHA256);
        String content = body + '.' + secretKey; // 所谓的根据body+secretKey
        return md5.digestHex(content); // base64UrlEncode(header) + "." + base64UrlEncode(payload), secret 更好一些
    }
}
