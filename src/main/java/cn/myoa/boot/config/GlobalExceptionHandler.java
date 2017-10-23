package cn.myoa.boot.config;

import cn.myoa.common.enu.CommonError;
import cn.myoa.common.enu.ReturnCode;
import cn.myoa.common.exception.NotFoundException;
import cn.myoa.common.exception.UnauthorizedException;
import cn.myoa.common.utils.result.Result;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.TypeMismatchException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by zhangbolun on 17/10/17.
 */
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {


    @Autowired
    private ObjectMapper om;

    @ExceptionHandler({org.springframework.web.bind.MethodArgumentNotValidException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public Result processNotValidExceptionError(org.springframework.web.bind.MethodArgumentNotValidException ex) {
        String exceptionMessage = ex.getMessage();
        log.info("\n\n" + exceptionMessage + "\n\n");
        String seperatorStr = "default message [";
        int seperatorLengeh = seperatorStr.length();
        int num = exceptionMessage.indexOf(seperatorStr) + seperatorLengeh;
        exceptionMessage = exceptionMessage.substring(num, exceptionMessage.length());
        num = exceptionMessage.indexOf(seperatorStr) + seperatorLengeh;
        exceptionMessage = exceptionMessage.substring(num, exceptionMessage.length());
        num = exceptionMessage.indexOf("]");
        exceptionMessage = exceptionMessage.substring(0, num);
        return new Result(ReturnCode.FAILURE.code, exceptionMessage);
    }

    @ExceptionHandler({TypeMismatchException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public Result process400Error(Exception ex) {
        log.error("400Exception:", ex);
        return new Result(ReturnCode.BADREQUEST.code, ex.getMessage());
    }

    @ExceptionHandler(UnauthorizedException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ResponseBody
    public Result process401Error(UnauthorizedException ex) {
        log.error("401 Exception: " + ex);
        return new Result(ReturnCode.UNAUTHORIZED.code, CommonError.访问无权限.toString());
    }

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public Result process404Error(NotFoundException ex) {
        log.error("404 NotFoundException : ", ex);
        return new Result(ReturnCode.NOTFOUND.code, ex.getMessage());
    }

}

