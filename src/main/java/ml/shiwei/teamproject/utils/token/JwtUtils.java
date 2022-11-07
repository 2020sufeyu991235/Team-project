package ml.shiwei.teamproject.utils.token;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import ml.shiwei.teamproject.dao.TokenDao;
import ml.shiwei.teamproject.entity.Token;
import ml.shiwei.teamproject.entity.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * @author: swl
 * @date: 2022/10/31
 * @description: jwt生成token工具类
 */
public class JwtUtils {
    //主题
    public static final String SUBJECT="shiwei";
    //密钥
    public static final String SECRET="team_shiwei";
    //过期时间
    public static final long EXPIRE=1000*60*30;

    /**
     * 生成Token对象
     * @param user  用户User实例
     * @return ml.shiwei.teamproject.entity.Token Token由到期时间Date和密文String组成
     * @author swl
     **/
    public static Token getJsonWebToken(User user){
        if(user==null || user.getId()==null || user.getUserName()==null ){
            return null;
        }
        return new Token(new Date(System.currentTimeMillis()+EXPIRE),Jwts.builder().setSubject(SUBJECT)
                .claim("id",user.getId())
                .claim("userName",user.getUserName())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis()+EXPIRE))
                .signWith(SignatureAlgorithm.HS256,SECRET).compact());
    }

    public static Claims checkToken(String string){
        return Jwts.parser().setSigningKey(SECRET).parseClaimsJws(string).getBody();
    }
}
