package ml.shiwei.teamproject.dao;

import ml.shiwei.teamproject.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author: swl
 * @date: 2022/10/31
 * @description: Comment访问数据库接口
 */
public interface CommentDao extends JpaRepository<Comment,Long> {
}
