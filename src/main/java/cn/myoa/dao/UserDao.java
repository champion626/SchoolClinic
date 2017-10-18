package cn.myoa.dao;

import cn.myoa.dao.validates.AddUser;
import cn.myoa.dao.validates.UpdateUser;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * Created by zhangbolun on 17/10/17.
 */
@Data
@NoArgsConstructor
public class UserDao implements Serializable {
    private int id;
    @NotNull(groups = {AddUser.class, UpdateUser.class}, message = "手机号不能为空")
    @Length(max = 11, min = 11, message = "请输入正确的手机号")
    private String phone;
    @NotNull(groups = {AddUser.class, UpdateUser.class}, message = "登录名不能为空")
    @Size(min = 5, max = 20, message = "登录名 应在 {min}-{max} 个字符之间")
    private String username;
    @NotNull(groups = {AddUser.class}, message = "密码不能为空")
    @Size(min = 6, max = 16, message = "密码 应在 {min}-{max} 个字符之间")
    private String password;
    @NotNull(groups = {AddUser.class}, message = "姓名不能为空")
    @Size(min = 3, max = 20, message = "姓名 应在 {min}-{max} 个字符之间")
    private String name;
    private String createTime;
    @NotNull(groups = {AddUser.class}, message = "状态不能为空")
    @Size(min = 1, max = 2, message = "状态 应在 {min}-{max} 个字符之间")
    private String status;
    private String email;

}

