package ml.shiwei.teamproject.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author: swl
 * @date: 2022/11/4
 * @description: 角色role数据表
 */
@Entity
@Table(name="role")
public class Role implements Serializable {
    private static final long serialVersionUID = -8473837905831755260L;

    @Id
    private int id;

    private String name;



    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Role() {
    }

    /**
     * Role构造方法
     * @param roleEnum 枚举类RoleEnum实例，如：RoleEnum.NormalUser
     * @author swl
     **/
    public Role(RoleEnum roleEnum){
        this.id= roleEnum.getId();
        this.name=roleEnum.getName();
    }

    public int getId() {
        return id;
    }

    public void setRole(RoleEnum roleEnum) {
        this.id= roleEnum.getId();
        this.name=roleEnum.getName();
    }

    public String getName() {
        return name;
    }
}
