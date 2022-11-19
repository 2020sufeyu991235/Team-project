package ml.shiwei.teamproject.user;

import ml.shiwei.teamproject.dao.UserDao;
import ml.shiwei.teamproject.dao.User_RoleDao;
import ml.shiwei.teamproject.entity.User;
import ml.shiwei.teamproject.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.ObjectUtils;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author tzf
 * @date 2022/11/10
 * @Description
 */
@RunWith(SpringRunner.class)
@SpringBootTest
class UserManageTest {
    @Autowired
    private UserService userService;

    @Autowired
    private UserDao userDao;

    @Autowired
    private User_RoleDao user_roleDao;
    @Test
    //查询所有测试
    void findIdAndUserNameAndRoleIdTest(){
        Page<User> all = userService.findAll(0, 5);
        System.out.println(all.getContent());
    }
    //条件查询测试
    @Test
    void findIdAndUserNameAndRoleIdTestConditional(){
        Page<User> all = userService.findAllConditional(null ,0,null,0,2);
        System.out.println(all);
    }

    //动态查询测试
    @Test
    void testspec() {
        Integer id = null;

        Integer roleId=null;
        String userName = null;

        Specification<User> spec = new Specification<User>() {
            @Override
            public Predicate toPredicate(Root<User> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                //构造查询
                //用于添加所有查询条件
                List<Predicate> p = new ArrayList<>();

                //1.用户id的精准匹配查询
                if(!ObjectUtils.isEmpty(id)){
                    Predicate p1 = cb.equal(root.get("id"), id);
                    p.add(p1);
                }

                //2.用户名的模糊匹配查询
                if(!ObjectUtils.isEmpty(userName)){
                    Predicate p2 = cb.equal(root.get("userName"), "%" + userName + "%");
                    p.add(p2);
                }
                //3.身份id的精准查询
                if(!ObjectUtils.isEmpty(roleId)){
                    Predicate p3 = cb.equal(root.get("user_role").get("roleId"), roleId);
                    p.add(p3);
                }
                //组合条件:与
                Predicate[] pre = new Predicate[p.size()];
                Predicate and = cb.and(p.toArray(pre));
                query.where(and);
                //4.设置排序
                List<Order> orders = new ArrayList<>();
                orders.add(cb.desc(root.get("user_role").get("roleId")));       //倒序
                orders.add(cb.asc(root.get("id")));   //正序
                return query.orderBy(orders).getRestriction();
            }
        };
        List<User> all = userDao.findAll(spec);
        System.out.println(all);
    }


    //修改身份测试
    @Test
    void changeById(){
        user_roleDao.updateRoleById(0,11L);
    }
}
