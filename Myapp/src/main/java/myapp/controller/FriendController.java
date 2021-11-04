package myapp.controller;

import myapp.service.FriendService;
import myapp.util.RespResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2021-09-02T00:36:41.717+08:00")

@RestController
public class FriendController extends BaseController implements FriendApi{
    @Autowired
    FriendService friendService;

    @Override
    public ResponseEntity<RespResult> addFriend(Integer uId, String fAccount) {
        RespResult respResult = friendService.addFriend(uId, fAccount);
        return new ResponseEntity<RespResult>(respResult, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<RespResult> inquireFriend(Integer id) {
        RespResult respResult = friendService.inquireFriend(id);
        return new ResponseEntity<RespResult>(respResult, HttpStatus.OK);
    }
}
