package ml.shiwei.teamproject.dao;

import ml.shiwei.teamproject.entity.User_Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author: swl
 * @date: 2022/11/4
 * @description: 对User_Role数据表进行操作
 */
public interface User_RoleDao extends JpaRepository<User_Role,Long> {
    /**
     * 根据用户id获取对应角色类对象
     * @param id 用户id
     * @return User_Role 角色类对象
     * @author swl
     **/
    //@Modifying
    //@Query(value="select * from user_role where user_id=?1",nativeQuery = true)
    //User_Role getRoleId(Long id);

    User_Role findByUserId(Long id);
}
