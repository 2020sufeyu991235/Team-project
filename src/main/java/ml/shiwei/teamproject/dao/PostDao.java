package ml.shiwei.teamproject.dao;

import ml.shiwei.teamproject.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository()
/**
 * @author: swl
 * @date: 2022/10/31
 * @description: Post访问数据库接口
 */
public interface PostDao extends JpaRepository<Post,Long> {
    /**
     * 根据饭堂+楼层读取相应帖子
     * @param canteen1 饭堂+一楼
    * @param canteen2 饭堂+二楼
     * @return java.util.List<ml.shiwei.teamproject.entity.Post> 以Post为元素的List列表
     * @author swl
     **/
    @Modifying
    @Query(value="select * from post where canteen=?1 or canteen=?2",nativeQuery = true)
    List<Post> findByCanteen(String canteen1, String canteen2);
}
