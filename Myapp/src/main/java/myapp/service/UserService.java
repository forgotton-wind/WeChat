package myapp.service;

import myapp.model.UserPo;
import myapp.util.RespResult;

public interface UserService {
    RespResult userLogin(String userAccount, String userPassword);
    RespResult userRegister(String account, String password1, String password2);
    RespResult userUpdate(UserPo userPo);
}
