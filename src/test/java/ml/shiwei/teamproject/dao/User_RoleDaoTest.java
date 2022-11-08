package ml.shiwei.teamproject.dao;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class User_RoleDaoTest {
    @Autowired
    User_RoleDao user_roleDao;

    @Test
    void findByUserId() {
        System.out.println(user_roleDao.findByUserId(2L).getRoleId());
    }
}