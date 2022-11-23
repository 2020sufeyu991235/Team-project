package ml.shiwei.teamproject.dao;

import ml.shiwei.teamproject.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author: swl
 * @date: 2022/10/31
 * @description: Comment访问数据库接口
 */
public interface CommentDao extends JpaRepository<Comment,Long> {
    //根据帖子id按评论id升序读取评论
    List<Comment> findByPostIdOrderByIdAsc(long postId);
    //根据用户id按评论id降序读取评论
    List<Comment> findByUserIdOrderByIdDesc(long userId);
}
