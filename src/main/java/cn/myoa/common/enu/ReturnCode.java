package cn.myoa.common.enu;

/**
 * Created by zhangbolun on 17/10/17.
 */
public enum  ReturnCode {
    SUCCESS("000"),
    FAILURE("111"),
    NOTFOUND("404"),
    BADREQUEST("400"),
    UNAUTHORIZED("401"),
    ;

    public String code;


    ReturnCode(){}

    ReturnCode(String code) {
        this.code = code;
    }
}
