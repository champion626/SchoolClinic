package cn.myoa.common.utils.result;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Created by zhangbolun on 17/10/17.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
//@JsonIgnoreProperties(ignoreUnknown = true)
//@JsonInclude
public class Result<T> implements Serializable {
    private String code;
    private String msg;
    private Page page;
    private T data;

    public Result setCode(String code) {
        this.code = code;
        return this;
    }

    public Result setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public Result setPage(Page page) {
        this.page = page;
        return this;
    }

    public Result setData(T data) {
        this.data = data;
        return this;
    }

    public Result (String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Result (String code, String msg,T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public Result (String code, String msg,T data,Page page) {
        this.code = code;
        this.msg = msg;
        this.data = data;
        this.page=page;
    }

}

