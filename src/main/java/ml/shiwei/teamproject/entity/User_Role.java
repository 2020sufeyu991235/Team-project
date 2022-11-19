package ml.shiwei.teamproject.entity;

import javax.persistence.*;
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

    @JoinColumn(name = "roleId",referencedColumnName = "id",insertable = false,updatable = false)
    @OneToOne
    private Role role;

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }


    public User_Role(){}

    public User_Role(Long userId, int roleId) {
        this.userId = userId;
        this.roleId = roleId;
    }

    @Override
    public String toString() {
        return "User_Role{" +
                "userId=" + userId +
                ", roleId=" + roleId +
                ", role=" + role.getName() +
                '}';
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
