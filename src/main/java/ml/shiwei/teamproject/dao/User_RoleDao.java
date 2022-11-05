package ml.shiwei.teamproject.dao;

import ml.shiwei.teamproject.entity.User_Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author: swl
 * @date: 2022/11/4
 * @description: 对User_Role数据表进行操作
 */
public interface User_RoleDao extends JpaRepository<User_Role,Long> {
}
