package ml.shiwei.teamproject.utils.identicon;

/**
 * @author: swl
 * @date: 2022/10/14 17:55
 * @description: 后端返回的数据进行统一格式处理
 */
public class Result {
    //状态码
    private Integer code;
    //信息
    private String message;
    //数据
    private Object data;

    /**
     * Result构造方法
     * @param resultCode 枚举类ResultCode实例，如：ResultCode.SUCCESS
     * @param data Object类型，需要返回的数据
     * @author swl
     **/
    public Result(ResultCode resultCode,Object data){
        this(resultCode);
        this.data=data;
    }
    
    /**
     * Result构造方法
     * @param resultCode 枚举类ResultCode实例，如：ResultCode.SUCCESS
     * @author swl
     **/
    public Result(ResultCode resultCode){
        this.code=resultCode.getCode();
        this.message= resultCode.getMessage();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
