package ml.shiwei.teamproject.service;

import ml.shiwei.teamproject.entity.User;
import org.springframework.data.domain.Page;

import java.util.List;

public interface UserService {
    //根据用户名查询用户信息
    User inquireByUserName(String userName);

    //分页查询所有
    public Page<User> findAll(int currentPage, int pageSize);

    //动态查询
    Page<User> findAllConditional(Long id,Integer roleId, String userName, Integer pageNo, Integer pageSize);

    //修改用户身份
    void ChangeById(Integer roleId,Long id);

    }
