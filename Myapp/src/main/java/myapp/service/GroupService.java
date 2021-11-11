package myapp.service;

import myapp.util.RespResult;

public interface GroupService {
    RespResult searchGroup(String name);
    RespResult addGroup(Integer gId, Integer uId);
    RespResult exitGroup(Integer gId, Integer uId);
    RespResult sendGroupMessage(Integer gId, Integer uId, String content, String time);
    RespResult receiveGroupMessage(Integer uId);
}
