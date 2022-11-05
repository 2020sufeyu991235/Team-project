package ml.shiwei.teamproject.dao;

import ml.shiwei.teamproject.entity.Role_Resource;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author: swl
 * @date: 2022/11/4
 * @description: 对角色资源数据表进行操作
 */
public interface Role_ResourceDao extends JpaRepository<Role_Resource,Integer> {
}
