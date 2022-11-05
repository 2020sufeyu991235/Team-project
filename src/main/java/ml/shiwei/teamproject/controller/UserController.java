package ml.shiwei.teamproject.controller;

import io.jsonwebtoken.Claims;
import ml.shiwei.teamproject.dao.UserDao;
import ml.shiwei.teamproject.entity.Token;
import ml.shiwei.teamproject.entity.User;
import ml.shiwei.teamproject.service.TokenService;
import ml.shiwei.teamproject.service.UserService;
import ml.shiwei.teamproject.utils.identicon.Result;
import ml.shiwei.teamproject.utils.identicon.ResultCode;
import ml.shiwei.teamproject.utils.token.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@Controller
/*
 * @RequestMapping
 * 在类处定义，规定初步的请求映射，相对于web应用的根目录
 */
@RequestMapping("/user")
public class UserController {
    //装载UserService接口对应实现类UserServiceImpl的对象
    @Autowired
    private UserService userService;
    @Autowired
    private TokenService tokenService;

    /*
     * @RequestMapping
     * 在方法处定义，进一步细分请求映射，相对于类定义处的映射
     */
    @RequestMapping("/login/html")
    public String loginHtml(){
        return "login";
    }

    @RequestMapping(value="/login",method= RequestMethod.POST)
    @ResponseBody
    public Result login(@RequestBody User user){
        if(user.getUserName()!=null || !Objects.equals(user.getUserName(), "")) {
            User user_dao = userService.inquireByUserName(user.getUserName());
            //密码正确
            if (user_dao.getPassWord().equals(user.getPassWord())) {
                //生成并将Token写入数据库
                Token token=tokenService.generateAndWrite(user_dao);
                //返回给前端的统一数据格式类Result，带有token
                return new Result(ResultCode.SUCCESS,token);
            }
            else {
                return new Result(ResultCode.PASSWORD_ERROR);
            }
        }
        //用户名为空
        else{
            return new Result(ResultCode.USERNAME_EMPTY);
        }
    }

    @RequestMapping(value = "/login/token")
    @ResponseBody
    public Result loginWithToken(@RequestHeader("Token") String string){
        if(string!=null){
            if(tokenService.findAndDelete(string)){
                return new Result(ResultCode.SUCCESS);
            }
            else {
                return new Result(ResultCode.TOKEN_OUTDATED);
            }
        }
        else{
            return new Result(ResultCode.TOKEN_EMPTY);
        }
    }
}
