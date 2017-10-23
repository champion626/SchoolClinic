package cn.myoa.common.exception;

/**
 * Created by zhangbolun on 17/10/17.
 */
public class NotFoundException extends RuntimeException{
    private String message;

    public NotFoundException(){

    }

    public NotFoundException(String message){
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
