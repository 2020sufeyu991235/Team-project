package ml.shiwei.teamproject.service.impl;

import ml.shiwei.teamproject.dao.TokenDao;
import ml.shiwei.teamproject.entity.Token;
import ml.shiwei.teamproject.entity.User;
import ml.shiwei.teamproject.service.TokenService;
import ml.shiwei.teamproject.utils.token.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author: swl
 * @date: 2022/10/31
 * @description:
 */
@Service
public class TokenServiceImpl implements TokenService {
    @Autowired
    private TokenDao tokenDao;

    @Override
    //生成并将Token写入数据库
    public Token generateAndWrite(User user) {
        Token token= JwtUtils.getJsonWebToken(user);
        tokenDao.save(token);
        return token;
    }

    @Override
    //查找并删除超时Token
    public boolean findAndDelete(String string) {
        Date date=new Date(System.currentTimeMillis());
        tokenDao.deleteOverdueToken(date);
        return tokenDao.existsByString(string);
    }
}
