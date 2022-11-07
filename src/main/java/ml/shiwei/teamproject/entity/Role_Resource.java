package ml.shiwei.teamproject.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author: swl
 * @date: 2022/11/4
 * @description: 角色资源联系表
 */
@Entity
@IdClass(Role_ResourceId.class)
@Table(name="role_resource")
public class Role_Resource implements Serializable {
    private static final long serialVersionUID = -5961679666292459595L;
    //复合主键
    @Id
    private int roleId;
    @Id
    private int resourceId;

    public Role_Resource() {
    }

    public Role_Resource(int roleId, int resourceId) {
        this.roleId = roleId;
        this.resourceId = resourceId;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public int getResourceId() {
        return resourceId;
    }

    public void setResourceId(int resourceId) {
        this.resourceId = resourceId;
    }
}
