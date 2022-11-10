package ml.shiwei.teamproject.user;

import com.alibaba.fastjson.JSON;
import ml.shiwei.teamproject.dao.UserDao;
import ml.shiwei.teamproject.entity.User;
import ml.shiwei.teamproject.vo.IdNameRoleVo;
import ml.shiwei.teamproject.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author tzf
 * @date 2022/11/10
 * @Description
 */
@RunWith(SpringRunner.class)
@SpringBootTest
class UserManageTest {
    @Autowired
    private UserDao userDao;

    @Test
    void findIdAndUserNameAndRoleIdTest(){
        List<IdNameRoleVo> idAndUserNameAndRoleId = userDao.findIdAndUserNameAndRoleId();
        String jsonString = JSON.toJSONString(idAndUserNameAndRoleId);
        System.out.println(jsonString);
    }

}
