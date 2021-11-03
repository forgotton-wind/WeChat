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
            method = RequestMethod.PUT)
    ResponseEntity<RespResult> addFriend(@NotNull @ApiParam(value = "本人id", required = true) @RequestParam(value = "f_uid") Integer uId,
                                         @NotNull @ApiParam(value = "好友id", required = true) @RequestParam(value = "f_fid") Integer fId
    );
}
