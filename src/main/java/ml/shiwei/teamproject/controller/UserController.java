package ml.shiwei.teamproject.controller;

import ml.shiwei.teamproject.dao.UserDao;
import ml.shiwei.teamproject.entity.User;
import ml.shiwei.teamproject.service.UserService;
import ml.shiwei.teamproject.utils.identicon.Result;
import ml.shiwei.teamproject.utils.identicon.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
/*
 * @RequestMapping
 * 在类处定义，规定初步的请求映射，相对于web应用的根目录
 */
@RequestMapping("/")
public class UserController {
    //装载UserService接口对应实现类UserServiceImpl的对象
    @Autowired
    private UserService userService;

    /*
     * @RequestMapping
     * 在方法处定义，进一步细分请求映射，相对于类定义处的映射
     */
    @RequestMapping(value="/")
    public String begin(){
        //返回begin.html页面给前端
        return "begin";
    }

    @RequestMapping(value="/login",method= RequestMethod.POST)
    @ResponseBody
    public Result login(@RequestBody User user){
        User user_dao=userService.inquireByUserName(user.getUserName());
        if(user_dao.getPassWord().equals(user.getPassWord())) {
            //返回给前端的统一数据格式类Result
            return new Result(ResultCode.SUCCESS);
        }
        else {
            return new Result(ResultCode.PASSWORD_ERROR);
        }
    }
}
