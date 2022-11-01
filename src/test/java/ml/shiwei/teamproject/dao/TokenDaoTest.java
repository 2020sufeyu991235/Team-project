package ml.shiwei.teamproject.dao;

import ml.shiwei.teamproject.entity.Token;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class TokenDaoTest {

    @Autowired
    private TokenDao tokenDao;
    @Test
    void deleteOverdueToken() {
        Date date=new Date(System.currentTimeMillis());
        //tokenDao.save(new Token(date,"1234"));
        tokenDao.deleteOverdueToken(date);
        //System.out.println(date);
    }
    @Test
    void existsByString() {
        assertFalse(tokenDao.existsByString("wers"));
    }
}