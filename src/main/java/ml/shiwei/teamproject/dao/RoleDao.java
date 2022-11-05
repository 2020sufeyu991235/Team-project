package ml.shiwei.teamproject.dao;

import ml.shiwei.teamproject.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author: swl
 * @date: 2022/11/4
 * @description: 对Role数据表进行操作
 */
public interface RoleDao extends JpaRepository<Role, Integer> {
}
