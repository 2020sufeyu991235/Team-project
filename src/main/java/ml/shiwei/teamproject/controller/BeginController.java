package ml.shiwei.teamproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author: swl
 * @date: 2022/11/1
 * @description: 初始界面控制器
 */
@Controller
@RequestMapping("/")
public class BeginController {
    @RequestMapping("/")
    public String begin(){
        //返回初始界面
        return "begin.html";
    }
}
