package myapp.service;

import myapp.util.RespResult;

public interface FriendService {
    RespResult addFriend(Integer uId, String fId);
    RespResult inquireFriend(Integer id);
}
