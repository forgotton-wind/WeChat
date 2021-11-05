package myapp.service.impl;

import myapp.mapper.FriendPoMapper;
import myapp.mapper.UserPoMapper;
import myapp.model.LoginData;
import myapp.model.UserPo;
import myapp.service.UserService;
import myapp.util.MD5Util;
import myapp.util.RespResult;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    UserPoMapper userPoMapper;
    @Resource
    FriendPoMapper friendPoMapper;

    @Override
    public RespResult userLogin(String userAccount, String userPassword) {
        if(userAccount.isEmpty()) {
            return RespResult.fail("用户名不能为空!");
        }
        if(userPassword.isEmpty()) {
            return RespResult.fail("密码不能为空!");
        }
        UserPo userPo = userPoMapper.selectUserByLoginName(userAccount);
        if(null==userPo) {
            return RespResult.fail("该用户名不存在!");
        }

        if(MD5Util.verifyMd5(userPassword,userPo.getPassword())) {
//            登录后，将state = 1 代表在线
            userPo.setState(1);
            userPoMapper.updateState(1);
            LoginData loginData = new LoginData();
            loginData.setUserPo(userPo);
            List<UserPo> userPoList = friendPoMapper.friendInfo(userPo.getUid());
            loginData.setLinkManList(userPoList);
            return RespResult.success("登录成功!", loginData);
        } else {
            return RespResult.fail("密码错误!");
        }
    }

    @Override
    public RespResult userRegister(String account, String password1, String password2) {
        UserPo userPo1 = userPoMapper.selectUserByLoginName(account);
        if(userPo1!=null) {
            return RespResult.fail("注册失败，该用户已存在!");
        } else if (!password1.equals(password2)) {
            return RespResult.fail("注册失败，两次输入的密码不一致!");
        } else {
            UserPo userPo = new UserPo();
            userPo.setUserAccount(account);
            userPo.setPassword(MD5Util.encodeMd5(password1));

            userPoMapper.insertSelective(userPo);
            return RespResult.success("注册成功!");
        }
    }

    @Override
    public RespResult userUpdate(UserPo userPo) {
        if(userPo.getPassword()!=null) {
            userPo.setPassword(MD5Util.encodeMd5(userPo.getPassword()));
        }
        userPoMapper.updateByPrimaryKeySelective(userPo);
        return RespResult.success("用户信息修改成功!");
    }
}
