package ml.shiwei.teamproject.service;

import ml.shiwei.teamproject.entity.Resource;

import java.util.List;

/**
 * @author: swl
 * @date: 2022/11/5
 * @description: 访问资源业务逻辑
 */
public interface ResourceService {
    /**
     * 根据用户id读取可访问资源
     * @param id 用户id，id=-1时表示用户未登录
     * @return java.util.List<ml.shiwei.teamproject.entity.Resource> 装载着资源类Resource对象的列表
     * @author swl
     **/
    List<String> list(Long id);
}
