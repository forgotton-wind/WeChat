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
                                         @NotNull @ApiParam(value = "好友账号", required = true) @RequestParam(value = "f_account") String fAccount
    );

    @ApiOperation(value = "查询好友列表", notes = "Inquire Friend", response = RespResult.class, tags={ "Friend", })
    @RequestMapping(value = "/friend/inquire",
            produces = { "application/json" },
            method = RequestMethod.POST)
    ResponseEntity<RespResult> inquireFriend(@NotNull @ApiParam(value = "本人id", required = true) @RequestParam(value = "f_uid") Integer id
    );
}
