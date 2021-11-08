package myapp.service.impl;

import myapp.mapper.MessagePoMapper;
import myapp.model.MessagePo;
import myapp.service.MessageService;
import myapp.util.RespResult;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import myapp.util.DateUtils;

@Service
public class MessageServiceImpl implements MessageService {
    @Resource
    MessagePoMapper messagePoMapper;

    @Override
    public RespResult messageTransmit(Integer mFromId, Integer mToId, String content, Integer type, String time) {
        MessagePo messagePo = new MessagePo();
        messagePo.setFromId(mFromId);
        messagePo.setToId(mToId);
        messagePo.setContent(content);
        messagePo.setTypeId(type);
        messagePo.setStatus(0);
        Date date = DateUtils.parseDate(time);
        messagePo.setTime(date);

        messagePoMapper.insertMessage(messagePo);

        return RespResult.success("发送成功!");
    }

    @Override
    public RespResult messageInquire(Integer id) {
        List<MessagePo> list = messagePoMapper.inquireMessage(id);

        if (list.isEmpty()) {
            return RespResult.success("无新消息");
        }
        return RespResult.success("有新消息", list);
    }

    @Override
    public RespResult setMessageReaded(Integer fromId, Integer toId) {
        messagePoMapper.setMessageReaded(fromId, toId);
        return RespResult.success("修改已读成功");
    }
}
