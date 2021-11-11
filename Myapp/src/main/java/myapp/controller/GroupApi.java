package myapp.controller;

import com.sun.istack.internal.NotNull;
import io.swagger.annotations.*;
import myapp.util.RespResult;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen",date = "2021-06-16T10:25:42")
@Api(value = "Group", description = "the Group API")

public interface GroupApi {
    @ApiOperation(value = "搜索群聊", notes = "Search Group", response = RespResult.class, tags={ "Group", })
    @RequestMapping(value = "/group/search",
            produces = { "application/json" },
            method = RequestMethod.POST)
    ResponseEntity<RespResult> searchGroup(@NotNull @ApiParam(value = "群聊名称", required = true) @RequestParam(value = "g_name") String name);

    @ApiOperation(value = "加入群聊", notes = "Add Group", response = RespResult.class, tags={ "Group", })
    @RequestMapping(value = "/group/add",
            produces = { "application/json" },
            method = RequestMethod.POST)
    ResponseEntity<RespResult> addGroup(@NotNull @ApiParam(value = "群聊id", required = true) @RequestParam(value = "g_id") Integer gId,
                                        @NotNull @ApiParam(value = "用户id", required = true) @RequestParam(value = "u_id") Integer uId
    );

    @ApiOperation(value = "退出群聊", notes = "Exit Group", response = RespResult.class, tags={ "Group", })
    @RequestMapping(value = "/group/exit",
            produces = { "application/json" },
            method = RequestMethod.POST)
    ResponseEntity<RespResult> exitGroup(@NotNull @ApiParam(value = "群聊id", required = true) @RequestParam(value = "g_id") Integer gId,
                                         @NotNull @ApiParam(value = "用户id", required = true) @RequestParam(value = "u_id") Integer uId
    );

    @ApiOperation(value = "发送群聊消息", notes = "Send Group Message", response = RespResult.class, tags={ "Group", })
    @RequestMapping(value = "/group/send",
            produces = { "application/json" },
            method = RequestMethod.POST)
    ResponseEntity<RespResult> sendGroupMessage(@NotNull @ApiParam(value = "群聊id", required = true) @RequestParam(value = "g_id") Integer gId,
                                                @NotNull @ApiParam(value = "用户id", required = true) @RequestParam(value = "u_id") Integer uId,
                                                @NotNull @ApiParam(value = "消息内容", required = true) @RequestParam(value = "content") String content,
                                                @NotNull @ApiParam(value = "时间", required = true) @RequestParam(value = "time") String time
    );

    @ApiOperation(value = "轮询群聊消息", notes = "receive Group Message", response = RespResult.class, tags={ "Group", })
    @RequestMapping(value = "/group/receive",
            produces = { "application/json" },
            method = RequestMethod.GET)
    ResponseEntity<RespResult> receiveGroupMessage(@NotNull @ApiParam(value = "用户id", required = true) @RequestParam(value = "u_id") Integer uId
    );
}
