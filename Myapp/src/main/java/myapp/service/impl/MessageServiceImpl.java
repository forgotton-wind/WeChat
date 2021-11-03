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
        /*
            假定  前端一直侦听某个端口x
            那么  就要向端口x发送一个数据包
            内容包括
                发送者id
                接受者id
                消息内容
                消息格式
                消息时间
            本台机器  假设有两个账号同时登录
            一起接收到数据包
            先判断 接受者id是不是自己
                不是的话直接过滤
                是的话，前端负责将消息渲染好显示在界面上
            前端返回一个消息已读
            后端改下数据库
            通话结束


            如果  接受者不在线
            后端发送后得不到返回
            消息保持默认状态未读
            等到每个账号登录在线后，前端自己向后端申请遍历一下message表，看下有没有属于自己的未读的消息
            有的话，后端返回，前端显示
         */

        return RespResult.success("发送成功!");
    }
}
