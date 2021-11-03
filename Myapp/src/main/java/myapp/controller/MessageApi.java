package myapp.controller;

import com.sun.istack.internal.NotNull;
import io.swagger.annotations.*;
import myapp.util.RespResult;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen",date = "2021-06-16T10:25:42")
@Api(value = "Message", description = "the Message API")
public interface MessageApi {
    @ApiOperation(value = "好友消息发送", notes = "Friends message transmit", response = RespResult.class, tags={ "User", })
    @RequestMapping(value = "/user/message",
            produces = { "application/json" },
            method = RequestMethod.POST)
    ResponseEntity<RespResult> messageTransmit(@NotNull @ApiParam(value = "发送者id", required = true) @RequestParam(value = "m_from_id") Integer mFromId,
                                         @NotNull @ApiParam(value = "接受者id", required = true) @RequestParam(value = "m_to_id") Integer mToId,
                                         @NotNull @ApiParam(value = "消息内容", required = true) @RequestParam(value = "content") String content,
                                         @NotNull @ApiParam(value = "消息类型", required = true) @RequestParam(value = "message_type") Integer type
    );
}
