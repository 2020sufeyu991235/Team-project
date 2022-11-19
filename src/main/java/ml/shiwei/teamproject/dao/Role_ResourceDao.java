package ml.shiwei.teamproject.dao;

import ml.shiwei.teamproject.entity.Role_Resource;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author: swl
 * @date: 2022/11/4
 * @description: 对角色资源数据表进行操作
 */
public interface Role_ResourceDao extends JpaRepository<Role_Resource,Integer> {
    /**
     * 根据角色id查找资源id
     * @param role_id 角色id
     * @return Role_Resource[] 角色资源联系类对象数组
     * @author swl
     **/
    //@Modifying
    //@Query(value="select * from role_resource where role_id=?1",nativeQuery = true)
    //Role_Resource[] getResourceId(int role_id);

    Role_Resource[] findByRoleId(int role_id);
}
