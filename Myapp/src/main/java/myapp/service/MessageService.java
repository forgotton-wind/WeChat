package myapp.service;

import myapp.util.RespResult;

import java.util.Date;

public interface MessageService {
    RespResult messageTransmit(Integer mFromId, Integer mToId, String content, Integer type, Date time);
    RespResult messageInquire(Integer id);
    RespResult setMessageReaded(Integer fromId, Integer toId);
}
