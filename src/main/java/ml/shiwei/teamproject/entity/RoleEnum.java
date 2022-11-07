package ml.shiwei.teamproject.entity;

/**
 * @author: swl
 * @date: 2022/11/4
 * @description: 对Role类的角色进行枚举和维护
 */
public enum RoleEnum {
    //禁言
    DisableSendMsg(0,"禁言"),
    //未登录
    NotLogIn(1,"未登录"),
    //普通用户
    NormalUser(2,"普通用户"),
    //管理员
    Administrator(3,"管理员"),
    //超级管理员
    SuperAdministrator(4,"超级管理员");

    private final int id;
    private final String name;

    RoleEnum(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
