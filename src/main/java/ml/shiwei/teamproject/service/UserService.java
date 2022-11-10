package ml.shiwei.teamproject.service;

import ml.shiwei.teamproject.vo.IdNameRoleVo;
import ml.shiwei.teamproject.entity.User;

import java.util.List;

public interface UserService {
    //根据用户名查询用户信息
    User inquireByUserName(String userName);

    //查询所有用户id，用户名，身份
    public List<IdNameRoleVo> findIdAndUserNameAndRoleId();
}
