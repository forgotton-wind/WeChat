package myapp.service.impl;

import myapp.mapper.FriendPoMapper;
import myapp.model.FriendPo;
import myapp.service.FriendService;
import myapp.util.RespResult;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

@Service
public class FriendServiceImpl implements FriendService {
    @Resource
    FriendPoMapper friendPoMapper;

    @Override
    public RespResult addFriend(Integer uId, Integer fId) {
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
}
