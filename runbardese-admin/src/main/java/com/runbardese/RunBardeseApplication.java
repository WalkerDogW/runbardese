package com.runbardese;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.scheduling.annotation.EnableScheduling;

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
    public static void main(String[] args)
    {

        //System.setProperty("spring.devtools.restart.enabled", "false");
        System.out.println("欢迎使用。。。。");
        SpringApplication.run(RunBardeseApplication.class, args);

    }

}