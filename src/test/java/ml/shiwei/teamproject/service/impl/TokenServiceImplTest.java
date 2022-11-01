package ml.shiwei.teamproject.service.impl;

import ml.shiwei.teamproject.service.TokenService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class TokenServiceImplTest {
    @Autowired
    private TokenService tokenService;

    @Test
    void findAndDelete() {
        assertTrue(tokenService.findAndDelete("wers"));
    }
}