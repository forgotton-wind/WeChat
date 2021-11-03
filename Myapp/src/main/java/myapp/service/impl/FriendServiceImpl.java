package myapp.service.impl;

import myapp.mapper.FriendPoMapper;
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
        friendPoMapper.addFriend(uId, fId);
        return RespResult.success("添加好友成功");
    }
}
