package ml.shiwei.teamproject.controller;

import ml.shiwei.teamproject.entity.User;
import ml.shiwei.teamproject.utils.identicon.ResultCode;
import ml.shiwei.teamproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import ml.shiwei.teamproject.utils.identicon.Result;

import java.util.List;

/**
 * @author tzf
 * @date 2022/11/9
 * @Description
 */

@RestController
public class UserManageController {

    @Autowired
    private UserService userService;

    @RequestMapping ( "/findAllByPageConditional")
    @ResponseBody
    public Result  findAllByPage(Integer currentPage,Long id,Integer roleId,String userName){

        Page<User> all = userService.findAllConditional(id,roleId,userName,currentPage-1, 10);

        return new Result(ResultCode.Success,all);
    }

    @RequestMapping ( "/ChangeById")
    @ResponseBody
    public void changeById(Integer roleId,Long id){
        userService.ChangeById(roleId,id);
    }
}
