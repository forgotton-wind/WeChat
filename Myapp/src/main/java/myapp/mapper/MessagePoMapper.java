package myapp.mapper;

import myapp.model.MessagePo;
import java.util.List;

public interface MessagePoMapper {
    Integer insertMessage(MessagePo messagePo);
    List<MessagePo> inquireMessage(Integer id);
    Integer setMessageReaded(Integer fromId, Integer toId);
}
