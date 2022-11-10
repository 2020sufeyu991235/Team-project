package ml.shiwei.teamproject.dao;

import ml.shiwei.teamproject.vo.IdNameRoleVo;
import ml.shiwei.teamproject.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

//将接口的一个实现类注册成bean放在loC容器中，由spring管理
@Repository()
/*
 * JpaRepository
 * 继承该接口可以获得SpringBoot Data JPA内置的多种基本数据操作方法。
 * 参考：https://blog.csdn.net/hbtj_1216/article/details/79773839
 */
public interface UserDao extends JpaRepository<User,Long> {
    //根据用户名查找用户User
    User findByUserName(String UserName);

    //查询所有用户的id，用户名，身份id
    @Query(value = "select new ml.shiwei.teamproject.vo.IdNameRoleVo(p.id,p.userName,q.roleId) from User p,User_Role  q where p.id=q.userId")
    public List<IdNameRoleVo> findIdAndUserNameAndRoleId();

}
