package cn.notemi.exception;

/**
 * Title：CustomException
 * Description：系统自定义异常类，针对预期的异常，需要在程序中抛出此类的异常
 *
 * @author Flicker
 * @create 2017-01-23 下午 9:26
 **/
public class CustomException extends Exception{

    //异常信息
    public String message;

    public CustomException(String message){
        super(message);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
