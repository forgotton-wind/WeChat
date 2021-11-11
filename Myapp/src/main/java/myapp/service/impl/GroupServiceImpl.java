package myapp.service.impl;

import myapp.mapper.GroupPoMapper;
import myapp.model.GroupMessagePo;
import myapp.model.GroupPo;
import myapp.service.GroupService;
import myapp.util.DateUtils;
import myapp.util.RespResult;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Service
public class GroupServiceImpl implements GroupService {
    @Resource
    GroupPoMapper groupPoMapper;

    public RespResult searchGroup(String name) {
        GroupPo groupPo = groupPoMapper.searchGroup(name);
        if (null == groupPo) {
            return RespResult.fail("找不到");
        }
        return RespResult.success("查找成功", groupPo);
    }

    public RespResult addGroup(Integer gId, Integer uId) {
        groupPoMapper.addGroup(gId, uId);
        return RespResult.success("加入成功");
    }

    public RespResult exitGroup(Integer gId, Integer uId) {
        groupPoMapper.exitGroup(gId, uId);
        return RespResult.success("退出成功");
    }

    public RespResult sendGroupMessage(Integer gId, Integer uId, String content, String time) {
        GroupMessagePo groupMessagePo = new GroupMessagePo();
        groupMessagePo.setGId(gId);
        groupMessagePo.setUId(uId);
        groupMessagePo.setContent(content);
        Date date = DateUtils.parseDate(time);
        groupMessagePo.setTime(date);
        groupMessagePo.setType(1);

        groupPoMapper.insertMessage(groupMessagePo);
        return RespResult.success("发送成功");
    }

    public RespResult receiveGroupMessage(Integer uId) {
        List<List<GroupMessagePo>> lists = new ArrayList<>();
        List<GroupPo> groupPoList = groupPoMapper.getGroupByUId(uId);
        for (GroupPo groupPo: groupPoList) {
            Integer gId = groupPo.getId();
            List<GroupMessagePo> list = groupPoMapper.receiveGroupMessage(gId);
            lists.add(list);
        }

        if (lists.isEmpty()) {
            return RespResult.success("无消息");
        }

        return RespResult.success("有消息", lists);
    }
}
