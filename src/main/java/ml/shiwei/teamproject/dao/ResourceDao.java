package ml.shiwei.teamproject.dao;

import ml.shiwei.teamproject.entity.Resource;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author: swl
 * @date: 2022/11/4
 * @description: 对访问资源数据表进行操作
 */
public interface ResourceDao extends JpaRepository<Resource,Integer> {
    /**
     * 根据资源id查询资源
     * @param id 资源id
     * @return ml.shiwei.teamproject.entity.Resource 资源类对象
     * @author swl
     **/
    Resource findById(int id);
}
