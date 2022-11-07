package ml.shiwei.teamproject.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author: swl
 * @date: 2022/11/4
 * @description: 用户角色联系表
 */
@Entity
@Table(name="user_role")
public class User_Role implements Serializable {
    private static final long serialVersionUID = -3046821418861762696L;

    @Id
    @Column(name="userId")
    private Long userId;
    @Column(name="roleId")
    private int roleId;

    public User_Role(){}

    public User_Role(Long userId, int roleId) {
        this.userId = userId;
        this.roleId = roleId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }
}
