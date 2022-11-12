package ml.shiwei.teamproject.service.impl;

import ml.shiwei.teamproject.dao.UserDao;
import ml.shiwei.teamproject.dao.User_RoleDao;
import ml.shiwei.teamproject.entity.User;
import ml.shiwei.teamproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
//实现UserService接口
public class UserServiceImpl implements UserService {
    /*
     * @Autowired
     * 自动装配，从loC容器查看相应的bean，返回实例对象
     * 参考：https://www.cnblogs.com/fnlingnzb-learner/p/9723834.html
     */
    @Autowired
    private UserDao userDao;

    @Autowired
    private User_RoleDao user_roleDao;

    @Override
    //根据用户名查询用户信息
    public User inquireByUserName(String userName) {
        return userDao.findByUserName(userName);
    }

    //分页查询所有
    @Override
    public Page<User> findAll(int currentPage, int pageSize) {
        Pageable pageable = PageRequest.of(currentPage, pageSize);
        return userDao.findAll(pageable);
    }



    @Override
    public Page<User> findAllConditional(Long id,Integer roleId, String userName, Integer pageNo, Integer pageSize) {
        //动态查询
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

        Pageable pageable = PageRequest.of(pageNo, pageSize);
        return userDao.findAll(spec,pageable);
    }

    @Override
    public void ChangeById(Integer roleId, Long id) {
        user_roleDao.updateRoleById(roleId,id);
    }


}
