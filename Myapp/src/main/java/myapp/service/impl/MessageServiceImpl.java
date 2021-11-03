package myapp.service.impl;

import myapp.mapper.MessagePoMapper;
import myapp.model.MessagePo;
import myapp.service.MessageService;
import myapp.util.RespResult;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
        messagePo.setStatus(1);

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
            所以后端发送前先检查接受者id 对应的 账号状态 是不是 离线
            离线的话就不发了


            每个账号登录在线后，前端自己向后端申请遍历一下message表，把历史消息显示出来（或者设置个数量限制？）
            也可以不搞这个（有时间再完善）
            未读的消息一定要显示


            核心问题：
                前端如何侦听指定端口
         */

        return RespResult.success("发送成功!");
    }

    @Override
    public RespResult messageInquire(Integer id) {
        List<MessagePo> list  = messagePoMapper.inquireMessage(id);

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
