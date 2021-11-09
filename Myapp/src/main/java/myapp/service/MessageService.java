package myapp.service;

import myapp.util.RespResult;
import java.sql.Date;


public interface MessageService {
    RespResult messageTransmit(Integer mFromId, Integer mToId, String content, Integer type, String time);
    RespResult messageInquire(Integer id);
    RespResult setMessageReaded(Integer fromId, Integer toId);
}
