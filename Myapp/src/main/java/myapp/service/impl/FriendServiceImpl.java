package myapp.service.impl;

import myapp.mapper.FriendPoMapper;
import myapp.mapper.UserPoMapper;
import myapp.model.FriendPo;
import myapp.model.UserPo;
import myapp.service.FriendService;
import myapp.util.RespResult;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

@Service
public class FriendServiceImpl implements FriendService {
    @Resource
    FriendPoMapper friendPoMapper;
    @Resource
    UserPoMapper userPoMapper;

    @Override
    public RespResult addFriend(Integer uId, Integer fId) {
        if (null == fId) {
            return RespResult.fail("此账号不存在");
        }
        if (fId.equals(uId)) {
            return RespResult.fail("不能添加自己");
        }
        List<FriendPo> list = friendPoMapper.inquireFriend(uId);
        for (FriendPo friendPo: list) {
            if (friendPo.getFId().equals(fId)) {
                return RespResult.fail("已经是好友");
            }
        }

        FriendPo friendPo = new FriendPo();
        friendPo.setUId(uId);
        friendPo.setFId(fId);
        friendPoMapper.addFriend(friendPo);
        return RespResult.success("添加好友成功");
    }

    @Override
    public RespResult inquireFriend(Integer id) {
        List<FriendPo> list = friendPoMapper.inquireFriend(id);
        return RespResult.success("查询成功", list);
    }

    @Override
    public RespResult findFriend(String account) {
        UserPo userPo = friendPoMapper.findFriend(account);
        if (null==userPo) return RespResult.fail("账号不存在");
        return RespResult.success("查找成功", userPo);
    }

    @Override
    public RespResult delFriend(Integer uId, Integer fId) {
        if (null == fId) {
            return RespResult.fail("此账号不存在");
        }
        if (fId.equals(uId)) {
            return RespResult.fail("不能删除自己");
        }
        FriendPo friendPo = friendPoMapper.isFriend(uId, fId);
        if (null == friendPo) {
            return RespResult.fail("不是好友，无法删除");
        }

        friendPoMapper.delFriend(uId, fId);
        return RespResult.success("删除好友成功");
    }
}
