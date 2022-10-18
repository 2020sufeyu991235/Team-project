package ml.shiwei.teamproject.service.impl;

import ml.shiwei.teamproject.dao.UserDao;
import ml.shiwei.teamproject.entity.User;
import ml.shiwei.teamproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
//实现UserService接口
public class UserServiceImpl implements UserService {
    /*
     * @Autowired
     * 自动装配，从loC容器查看相应的bean，返回实例对象
     * 参考：https://www.cnblogs.com/fnlingnzb-learner/p/9723834.html
     */
    @Autowired
    private UserDao userDao;

    @Override
    //根据用户名查询用户信息
    public User inquireByUserName(String userName) {
        return userDao.findByUserName(userName);
    }
}
