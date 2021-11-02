package myapp.service.impl;

import myapp.mapper.MessagePoMapper;
import myapp.model.MessagePo;
import myapp.service.MessageService;
import myapp.util.RespResult;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.Date;

@Service
public class MessageServiceImpl implements MessageService {
    @Resource
    MessagePoMapper messagePoMapper;

    @Override
    public RespResult messageTransmit(Integer mFromId, Integer mToId, String content, Integer type) {
        MessagePo messagePo = new MessagePo();
        messagePo.setFromId(mFromId);
        messagePo.setToId(mToId);
        messagePo.setContent(content);
        messagePo.setTypeId(type);
        messagePo.setTime(new Date());

        //TODO 时间可能要处理格式才行

        messagePoMapper.insertMessage(messagePo);

        //TODO 实际将消息发送到接受者

        return RespResult.success("发送成功!");
    }
}
