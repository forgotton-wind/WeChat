package myapp.service.impl;

import myapp.mapper.FriendPoMapper;
import myapp.model.FriendPo;
import myapp.model.MessagePo;
import myapp.service.FriendService;
import myapp.util.RespResult;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

@Service
public class FriendServiceImpl implements FriendService {
    @Resource
    FriendPoMapper friendPoMapper;

    @Override
    public RespResult addFriend(Integer uId, Integer fId) {
        //TODO 判断已经存在 好友关系
        FriendPo friendPo = new FriendPo();
        friendPo.setUId(uId);
        friendPo.setFId(fId);
        friendPoMapper.addFriend(friendPo);
        return RespResult.success("添加好友成功");
    }
}
