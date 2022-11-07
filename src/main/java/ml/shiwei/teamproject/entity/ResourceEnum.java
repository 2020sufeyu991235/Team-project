package ml.shiwei.teamproject.entity;

/**
 * @author: swl
 * @date: 2022/11/4
 * @description: 访问资源枚举类，用于维护访问资源
 */
public enum ResourceEnum {
    Begin(0,"/","初始界面"),
    LoginHtml(1,"/user/login/html","登录界面"),
    Login(2,"/user/login","登录请求"),
    LoginWithToken(3,"/user/login/token","token自动登录"),
    Posting(4,"/posting","发帖请求"),
    UploadImage(5,"/posting/upload","在帖子中上传图片");

    private final int id;
    private final String path;
    private final String name;

    ResourceEnum(int id, String path, String name) {
        this.id = id;
        this.path = path;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getPath() {
        return path;
    }

    public String getName() {
        return name;
    }
}
