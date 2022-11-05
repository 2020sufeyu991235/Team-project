package ml.shiwei.teamproject.service.impl;

import ml.shiwei.teamproject.dao.Role_ResourceDao;
import ml.shiwei.teamproject.dao.User_RoleDao;
import ml.shiwei.teamproject.entity.Resource;
import ml.shiwei.teamproject.entity.Role_Resource;
import ml.shiwei.teamproject.entity.User_Role;
import ml.shiwei.teamproject.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author: swl
 * @date: 2022/11/5
 * @description:
 */
public class ResourceServiceImpl implements ResourceService {
    @Autowired
    private User_RoleDao user_roleDao;
    @Autowired
    private Role_ResourceDao role_resourceDao;

    @Override
    public List<Resource> list(Long id) {
        //User_Role user_role=user_roleDao
        return null;
    }
}
