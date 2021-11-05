package myapp.service;

import myapp.util.RespResult;

public interface FriendService {
    RespResult addFriend(Integer uId, Integer fId);
    RespResult inquireFriend(Integer id);
    RespResult findFriend(String account);
}
