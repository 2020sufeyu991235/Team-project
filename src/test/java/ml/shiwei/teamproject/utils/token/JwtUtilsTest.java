package ml.shiwei.teamproject.utils.token;

import io.jsonwebtoken.Claims;
import ml.shiwei.teamproject.entity.Token;
import ml.shiwei.teamproject.entity.User;
import org.junit.jupiter.api.Test;

class JwtUtilsTest {

    @Test
    void getJsonWebToken() {
        User user=new User();
        user.setId(1L);
        user.setUserName("swl");
        Token token=JwtUtils.getJsonWebToken(user);
        System.out.println(token);
    }

    @Test
    void checkToken() {
        User user=new User();
        user.setId(1L);
        user.setUserName("swl");
        Token token=JwtUtils.getJsonWebToken(user);

        Claims claims=JwtUtils.checkToken(token.getString());
        long id= (int) claims.get("id");
        String userName= (String) claims.get("userName");
        System.out.println(id);
        System.out.println(userName);
    }
}