package ml.shiwei.teamproject.utils.identicon;

/**
 * @author: swl
 * @date: 2022/10/16
 * @description: 维护状态码
 */
public enum ResultCode {
    SUCCESS(200,"请求成功"),
    PASSWORD_ERROR(199,"密码错误"),
    WARN(198,"网络异常，请稍后重试");

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
