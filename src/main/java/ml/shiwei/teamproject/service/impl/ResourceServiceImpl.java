package ml.shiwei.teamproject.service.impl;

import ml.shiwei.teamproject.dao.ResourceDao;
import ml.shiwei.teamproject.dao.Role_ResourceDao;
import ml.shiwei.teamproject.dao.User_RoleDao;
import ml.shiwei.teamproject.entity.Role_Resource;
import ml.shiwei.teamproject.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: swl
 * @date: 2022/11/5
 * @description:
 */
@Service
public class ResourceServiceImpl implements ResourceService {
    @Autowired
    private User_RoleDao user_roleDao;
    @Autowired
    private Role_ResourceDao role_resourceDao;
    @Autowired
    private ResourceDao resourceDao;

    /**
     * 根据用户id读取可访问资源
     * @param id 用户id，id=-1时表示用户未登录
     * @return java.util.List<ml.shiwei.teamproject.entity.Resource> 装载着资源类Resource对象的列表
     * @author swl
     **/
    @Override
    public List<String> list(Long id) {
        //查找对应角色id
        int role_id;
        //未登录用户
        if(id==-1L){
            role_id=1;
        }
        //登录用户
        else {
            role_id=user_roleDao.findByUserId(id).getRoleId();
        }
        //查找角色对应资源id
        Role_Resource[] role_resources=role_resourceDao.findByRoleId(role_id);
        List<String> resourceList=new ArrayList<>();
        for(Role_Resource role_resource:role_resources){
            resourceList.add(resourceDao.findById(role_resource.getResourceId()).getPath());
        }
        return resourceList;
    }
}
