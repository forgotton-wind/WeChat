package myapp.mapper;

import myapp.model.FriendPo;
import myapp.model.UserPo;

import java.util.List;

public interface FriendPoMapper {
    Integer addFriend(FriendPo friendPo);
    List<FriendPo> inquireFriend(Integer id);
    UserPo findFriend(String account);
}
