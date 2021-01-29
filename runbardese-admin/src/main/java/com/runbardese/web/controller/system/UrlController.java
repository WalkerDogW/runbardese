package com.runbardese.web.controller.system;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Tao
 * @Date 2020/11/28
 * @Time 17:32
 */
@Controller
public class UrlController {
    @GetMapping("meeting")
    public String toUrl(){
        return "redirect:http://www.baidu.com";
    }
}
