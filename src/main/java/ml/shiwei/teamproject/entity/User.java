package ml.shiwei.teamproject.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
/*
 * @Table
 * 定义数据库中的表名，缺省表名为类名
 */
@Table(name="user")
/*
 * Serializable接口
 * 一个空接口，目的是简单的标识一个类的对象可以被序列化成json类型
 * 一个类只有实现了Serializable接口，它的对象才是可序列化的
 */
public class User implements Serializable {
    /*
     * serialVersionUID
     * 实现Serializable接口都需要设置，用于验证版本一致性
     * IDEA自动生成serialVersionUID参考：https://blog.csdn.net/gnail_oug/article/details/80263383
     */
    private static final long serialVersionUID = -2345330394868694695L;

    /*
     * @Id
     * 标记该变量为主键
     */
    @Id
    /*
     * @GeneratedValue
     * 标记变量为自增
     */
    @GeneratedValue
    private Long id;
    /*
     *@Column
     * 表元素
     **/
    @Column(name="username")
    private String userName;
    @Column(name="password")
    private String passWord;

    public User(){}

    public User(String userName,String passWord){
        this.userName=userName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                '}';
    }
}
