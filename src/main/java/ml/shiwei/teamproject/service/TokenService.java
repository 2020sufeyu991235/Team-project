package ml.shiwei.teamproject.service;

import ml.shiwei.teamproject.entity.Token;
import ml.shiwei.teamproject.entity.User;

/**
 * @author: swl
 * @date: 2022/10/31
 * @description: Token业务逻辑
 */
public interface TokenService {
    //生成并将Token写入数据库
    Token generateAndWrite(User user);
    //查找并删除超时Token
    boolean findAndDelete(String string);
}
