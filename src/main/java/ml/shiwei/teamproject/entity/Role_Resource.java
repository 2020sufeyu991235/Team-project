package ml.shiwei.teamproject.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author: swl
 * @date: 2022/11/4
 * @description: 角色资源联系表
 */
@Entity
@Table(name="role_resource")
public class Role_Resource implements Serializable {
    private static final long serialVersionUID = -5961679666292459595L;

    @Id
    @GeneratedValue
    private int role_id;

    private int resource_id;

    public Role_Resource() {
    }

    public Role_Resource(int role_id, int resource_id) {
        this.role_id = role_id;
        this.resource_id = resource_id;
    }

    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }

    public int getResource_id() {
        return resource_id;
    }

    public void setResource_id(int resource_id) {
        this.resource_id = resource_id;
    }
}
