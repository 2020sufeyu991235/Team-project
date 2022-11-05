package ml.shiwei.teamproject.service;

import ml.shiwei.teamproject.entity.Resource;

import java.util.List;

/**
 * @author: swl
 * @date: 2022/11/5
 * @description: 访问资源业务逻辑
 */
public interface ResourceService {
    //根据用户ID查找相应的权限
    List<Resource> list(Long id);
}
