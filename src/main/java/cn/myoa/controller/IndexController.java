package cn.myoa.controller;

import cn.myoa.common.enu.ReturnCode;
import cn.myoa.common.utils.result.Result;
import cn.myoa.dao.UserDao;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by zhangbolun on 17/10/17.
 */
@RestController
@RequestMapping("/Index")
public class IndexController {

    @PostMapping("/List")
    public Result testGet2(@RequestBody List<UserDao> userDaoList){
        return new Result(ReturnCode.SUCCESS.code, "测试成功", userDaoList);
    }

    @GetMapping("/Get")
    public Result testGet(@RequestParam(value = "vipCardNo", required = true) String vipCardNo) throws Exception {

        return new Result(ReturnCode.SUCCESS.code, "测试成功", vipCardNo.contains("4"));
    }

    @PutMapping("/Put")

    public Result testPut(){
        return new Result(ReturnCode.SUCCESS.code, "测试成功");
    }

    @PostMapping("/Post")
    public Result testPost(){
        return new Result(ReturnCode.SUCCESS.code, "测试成功");
    }

    @DeleteMapping("/Delete")
    public Result testDelete(){
        return new Result(ReturnCode.SUCCESS.code, "测试成功");
    }


}

