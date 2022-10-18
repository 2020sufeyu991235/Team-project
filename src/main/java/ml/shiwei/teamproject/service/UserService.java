package ml.shiwei.teamproject.service;

import ml.shiwei.teamproject.entity.User;

public interface UserService {
    //根据用户名查询用户信息
    User inquireByUserName(String userName);
}
