package myapp.controller;

import myapp.model.UserPo;
import myapp.service.UserService;
import myapp.util.RespResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2021-09-02T00:36:41.717+08:00")

@RestController
public class UserController extends BaseController implements UserApi {

    @Autowired
    private UserService userService;

    @Override
    public ResponseEntity<RespResult> userLogin(String userAccount, String userPassword) {
        RespResult respResult = userService.userLogin(userAccount, userPassword);
        return new ResponseEntity<RespResult>(respResult, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<RespResult> userRegister(String account, String password1, String password2) {
        RespResult respResult = userService.userRegister(account, password1, password2);
        return new ResponseEntity<RespResult>(respResult, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<RespResult> userUpdate(UserPo userPo) {
        RespResult  respResult= userService.userUpdate(userPo);
        return new ResponseEntity<RespResult>(RespResult.success(respResult),HttpStatus.OK);
    }

}
