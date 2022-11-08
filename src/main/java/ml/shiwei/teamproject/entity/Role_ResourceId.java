package ml.shiwei.teamproject.entity;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author: swl
 * @date: 2022/11/6
 * @description: 为了Role_Resource能创建复合主键而创建的类
 */
public class Role_ResourceId implements Serializable {
    private static final long serialVersionUID = -2538748483699302225L;

    private int roleId;
    private int resourceId;

    public Role_ResourceId(){

    }

    public Role_ResourceId(int roleId, int resourceId) {
        this.roleId = roleId;
        this.resourceId = resourceId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Role_ResourceId that = (Role_ResourceId) o;
        return roleId == that.roleId && resourceId == that.resourceId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(roleId, resourceId);
    }
}
