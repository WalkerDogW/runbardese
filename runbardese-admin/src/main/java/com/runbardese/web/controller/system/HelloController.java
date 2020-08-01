package com.runbardese.web.controller.system;

import com.runbardese.system.mapper.HelloMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author Tao
 * @Date 2020/7/29
 * @Time 15:14
 */
@RestController
@RequestMapping("/bds/api")
public class HelloController {

    @Autowired
    private HelloMapper helloMapper;




    @GetMapping("/hello")
    public String hello(){
        System.out.println(helloMapper.hello());
        System.out.println(helloMapper.hello2());
        return "Hello";
    }



}
