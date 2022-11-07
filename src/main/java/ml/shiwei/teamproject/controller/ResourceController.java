package ml.shiwei.teamproject.controller;

import io.jsonwebtoken.Claims;
import ml.shiwei.teamproject.service.impl.ResourceServiceImpl;
import ml.shiwei.teamproject.utils.token.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author: swl
 * @date: 2022/11/6
 * @description: 访问资源接口
 */
@Controller
@RequestMapping("/resource")
public class ResourceController {
    @Autowired
    ResourceServiceImpl resourceServiceImpl;

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    @ResponseBody
    public List<String> getList(@RequestHeader("Token") String string){
        Claims claims= JwtUtils.checkToken(string);
        long userId= (int) claims.get("id");
        return resourceServiceImpl.list(userId);
    }
}
