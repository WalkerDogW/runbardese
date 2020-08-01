package com.runbardese;

import org.apache.shiro.codec.Base64;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.scheduling.annotation.EnableScheduling;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.NoSuchAlgorithmException;

/**
 * 启动程序
 * 
 * @author RunJ
 */
@SpringBootApplication(exclude = {
        DataSourceAutoConfiguration.class
})
@ImportResource(locations = { "classpath:cxf-config.xml" })
@EnableScheduling
public class RunBardeseApplication
{
    public static void main(String[] args) throws NoSuchAlgorithmException {

        //System.setProperty("spring.devtools.restart.enabled", "false");
        System.out.println("欢迎使用。。。。");
        SpringApplication.run(RunBardeseApplication.class, args);

        //生成唯一秘钥
        /*
        KeyGenerator keygen = KeyGenerator.getInstance("AES");
        SecretKey deskey = keygen.generateKey();
        System.out.println(Base64.encodeToString(deskey.getEncoded()));

         */

    }

}