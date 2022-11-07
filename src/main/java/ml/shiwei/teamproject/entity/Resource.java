package ml.shiwei.teamproject.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author: swl
 * @date: 2022/11/4
 * @description: 访问资源数据表
 */
@Entity
@Table(name="resource")
public class Resource implements Serializable {
    private static final long serialVersionUID = 4513271071563386609L;

    @Id
    @GeneratedValue
    private int id;

    //访问资源路径
    private String path;
    private String name;

    public Resource() {
    }

    /**
     * Resource构造方法
     * @param resourceEnum ResourceEnum枚举类实例，如：ResourceEnum.Begin
     * @author swl
     **/
    public Resource(ResourceEnum resourceEnum){
        this.id=resourceEnum.getId();
        this.path=resourceEnum.getPath();
        this.name=resourceEnum.getName();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
