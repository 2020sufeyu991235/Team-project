package ml.shiwei.teamproject.dao;

import ml.shiwei.teamproject.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository()
/**
 * @author: swl
 * @date: 2022/10/31
 * @description: Post访问数据库接口
 */
public interface PostDao extends JpaRepository<Post,Long> {
}
