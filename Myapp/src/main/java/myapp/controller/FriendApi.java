package myapp.controller;

import com.sun.istack.internal.NotNull;
import io.swagger.annotations.*;
import myapp.util.RespResult;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen",date = "2021-06-16T10:25:42")
@Api(value = "Friend", description = "the Friend API")

public interface FriendApi {
    @ApiOperation(value = "添加好友", notes = "Add Friend", response = RespResult.class, tags={ "Friend", })
    @RequestMapping(value = "/friend/add",
            produces = { "application/json" },
            method = RequestMethod.POST)
    ResponseEntity<RespResult> addFriend(@NotNull @ApiParam(value = "本人id", required = true) @RequestParam(value = "f_uid") Integer uId,
                                         @NotNull @ApiParam(value = "好友id", required = true) @RequestParam(value = "f_id") Integer fId
    );

    @ApiOperation(value = "查询好友列表", notes = "Inquire Friend", response = RespResult.class, tags={ "Friend", })
    @RequestMapping(value = "/friend/inquire",
            produces = { "application/json" },
            method = RequestMethod.POST)
    ResponseEntity<RespResult> inquireFriend(@NotNull @ApiParam(value = "本人id", required = true) @RequestParam(value = "f_uid") Integer id
    );

    @ApiOperation(value = "查找好友", notes = "Find Friend", response = RespResult.class, tags={ "Friend", })
    @RequestMapping(value = "/friend/find",
            produces = { "application/json" },
            method = RequestMethod.POST)
    ResponseEntity<RespResult> findFriend(@NotNull @ApiParam(value = "查找账号", required = true) @RequestParam(value = "account") String account
    );

    @ApiOperation(value = "删除好友", notes = "Del Friend", response = RespResult.class, tags={ "Friend", })
    @RequestMapping(value = "/friend/del",
            produces = { "application/json" },
            method = RequestMethod.POST)
    ResponseEntity<RespResult> delFriend(@NotNull @ApiParam(value = "本人id", required = true) @RequestParam(value = "f_uid") Integer uId,
                                         @NotNull @ApiParam(value = "好友id", required = true) @RequestParam(value = "f_id") Integer fId
    );
}
