package myapp.controller;

import com.sun.istack.internal.NotNull;
import io.swagger.annotations.*;
import myapp.model.UserPo;
import myapp.util.RespResult;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen",date = "2021-06-16T10:25:42")
@Api(value = "User", description = "the User API")
public interface UserApi {
    @ApiOperation(value = "用户登录", notes = "User login", response = RespResult.class, tags={ "User", })
    @RequestMapping(value = "/user/login",
            produces = { "application/json" },
            method = RequestMethod.POST)
    ResponseEntity<RespResult> userLogin(@NotNull @ApiParam(value = "登录账号", required = true) @RequestParam(value = "user_account") String userAccount,
                                         @NotNull @ApiParam(value = "登录密码", required = true) @RequestParam(value = "user_password") String userPassword
    );

    @ApiOperation(value = "用户注册", notes = "User register", response = RespResult.class, tags = { "User", })
    @RequestMapping(value = "/user/register",
            produces = { "application/json" },
            method = RequestMethod.POST)
    ResponseEntity<RespResult> userRegister(@NotNull @ApiParam(value = "账号", required = true) @RequestParam(value = "user_account") String account,
                                            @NotNull @ApiParam(value = "密码", required = true) @RequestParam(value = "user_password") String password1,
                                            @NotNull @ApiParam(value = "确认密码", required = true) @RequestParam(value = "confirm_password") String password2
    );

    @ApiOperation(value = "修改个人信息", notes = "User update", response = RespResult.class, tags = { "User", })
    @RequestMapping(value = "/user/update",
            produces = { "application/json" },
            method = RequestMethod.PUT)
    ResponseEntity<RespResult> userUpdate(@RequestBody UserPo userPo);
}
