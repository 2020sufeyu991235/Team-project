package ml.shiwei.teamproject.vo;

import ml.shiwei.teamproject.entity.User;
import ml.shiwei.teamproject.entity.User_Role;

/**
 * @author tzf
 * @date 2022/11/10
 * @Description
 */
public class IdNameRoleVo {
    private Long id;
    private String userName;
    private int roleId;

    public IdNameRoleVo(Long id, String userName, int roleId) {
        this.id = id;
        this.userName = userName;
        this.roleId = roleId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
