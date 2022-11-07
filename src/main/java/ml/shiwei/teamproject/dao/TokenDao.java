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
    /**
     * 删除过期Token
     * @param date 当前时间
     * @author swl
     **/
    @Transactional
    @Modifying
    @Query(value="delete from token where date<?1",nativeQuery = true)
    void deleteOverdueToken(Date date);

    /**
     * 根据字符串判断数据库里是否有该Token
     * @param string Token的String字段
     * @return boolean 如果Token未失效，返回true，反之
     * @author swl
     **/
    boolean existsByString(String string);
}
