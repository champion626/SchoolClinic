package cn.myoa.common.enu;

/**
 * Created by zhangbolun on 17/10/17.
 */
public enum ReturnMsg {

    RESPONSE_SUCCESS("请求响应成功"),
    System_Error("系统错误"),
    ADD_SUCCESS("添加成功"),
    ADD_FAILURE("添加失败"),
    UPDATE_SUCCESS("更新成功"),
    UPDATE_FAILURE("更新失败"),
    FOUND_SUCCESS("查询成功"),
    FOUND_FAILURE("查询失败,信息不存在"),
    Parameter_error("参数错误")

    ;

    public String msg;


    ReturnMsg(){}

    ReturnMsg(String msg) {
        this.msg = msg;
    }
}

