package ml.shiwei.teamproject.entity;

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
    private Long user_id;

    private int role_id;

    public User_Role(){}

    public User_Role(Long user_id, int role_id) {
        this.user_id = user_id;
        this.role_id = role_id;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }
}
