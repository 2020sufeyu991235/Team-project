package ml.shiwei.teamproject.entity;

/**
 * @author: swl
 * @date: 2022/11/4
 * @description: 对Role类的角色进行枚举和维护
 */
public enum RoleEnum {
    DisableSendMsg(0,"disableSendMsg"),
    NormalUser(1,"normalUser"),
    Administrator(2,"administrator"),
    SuperAdministrator(3,"superAdministrator");

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
