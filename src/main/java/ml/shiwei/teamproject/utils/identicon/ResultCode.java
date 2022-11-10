package ml.shiwei.teamproject.utils.identicon;

/**
 * @author: swl
 * @date: 2022/10/16
 * @description: 维护状态码
 */
public enum ResultCode {
    Success(200,"请求成功"),
    Forbidden(403,"没有权限"),
    NotFound(404,"未找到资源"),
    Internal_Server_Error(500,"服务器未响应"),
    UserName_Empty(10000,"用户名为空"),
    Password_Error(10001,"密码错误"),
    Token_Outdated(10002,"Token失效"),
    Token_Empty(10003,"Token为空"),
    File_Empty(10004,"上传文件为空");

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

    /*public static ResultCode getEnumByCode(int code){
        for(ResultCode resultCode:ResultCode.values()){
            if(resultCode.getCode()==code){
                return resultCode;
            }
        }
        return null;
    }*/
}
