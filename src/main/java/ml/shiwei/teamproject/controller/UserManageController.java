package ml.shiwei.teamproject.controller;

import com.alibaba.fastjson.JSON;
import ml.shiwei.teamproject.vo.IdNameRoleVo;
import ml.shiwei.teamproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping( "/findIdAndUserNameAndRoleId")
    public String findIdAndUserNameAndRoleId(){

        List<IdNameRoleVo> idAndUserNameAndRoleId = userService.findIdAndUserNameAndRoleId();

        String jsonString = JSON.toJSONString(idAndUserNameAndRoleId);

        return jsonString;
    }
}
