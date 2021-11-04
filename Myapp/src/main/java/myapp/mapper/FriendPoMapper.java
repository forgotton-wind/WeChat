package myapp.mapper;

import myapp.model.FriendPo;
import java.util.List;

public interface FriendPoMapper {
    Integer addFriend(FriendPo friendPo);
    List<FriendPo> inquireFriend(Integer id);
}
