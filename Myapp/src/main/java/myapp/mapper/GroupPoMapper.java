package myapp.mapper;

import myapp.model.GroupMessagePo;
import myapp.model.GroupPo;
import java.util.List;

public interface GroupPoMapper {
    GroupPo searchGroup(String name);
    Integer addGroup(Integer gId, Integer uId);
    Integer exitGroup(Integer gId, Integer uId);
    Integer insertMessage(GroupMessagePo groupMessagePo);
    List<GroupMessagePo> receiveGroupMessage(Integer gId);
}
