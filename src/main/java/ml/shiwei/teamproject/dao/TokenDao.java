package ml.shiwei.teamproject.dao;

import ml.shiwei.teamproject.entity.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.Date;


/**
 * @author: swl
 * @date: 2022/10/31
 * @description: token访问数据库接口
 */
public interface TokenDao extends JpaRepository<Token, Date> {
    //删除过期Token
    @Transactional
    @Modifying
    @Query(value="delete from token where date<?1",nativeQuery = true)
    void deleteOverdueToken(Date date);

    //判断字符串是否存在
    boolean existsByString(String string);
}
