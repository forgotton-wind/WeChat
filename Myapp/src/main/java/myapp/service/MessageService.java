package myapp.service;

import myapp.util.RespResult;

public interface MessageService {
    RespResult messageTransmit(Integer mFromId, Integer mToId, String content, Integer type);
    RespResult messageInquire(Integer id);
    RespResult setMessageReaded(Integer fromId, Integer toId);
}
