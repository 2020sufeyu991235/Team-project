package ml.shiwei.teamproject.utils.identicon;

/**
 * @author: swl
 * @date: 2022/10/16
 * @description: 维护状态码
 */
public enum ResultCode {
    SUCCESS(200,"请求成功"),
    Forbidden(403,"没有权限"),
    USERNAME_EMPTY(10000,"用户名为空"),
    PASSWORD_ERROR(10001,"密码错误"),
    TOKEN_OUTDATED(10002,"Token失效"),
    TOKEN_EMPTY(10003,"Token为空");

    private final int code;
    private final String message;

    ResultCode(int code,String message){
        this.code=code;
        this.message=message;
    }

    public int getCode(){
        return code;
    }

    public String getMessage() {
        return message;
    }
}
