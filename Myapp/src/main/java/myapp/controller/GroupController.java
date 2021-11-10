package myapp.controller;

import myapp.service.GroupService;
import myapp.util.RespResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2021-09-02T00:36:41.717+08:00")

@RestController
public class GroupController extends BaseController implements GroupApi{
    @Autowired
    GroupService groupService;

    @Override
    public ResponseEntity<RespResult> searchGroup(String name) {
        RespResult respResult = groupService.searchGroup(name);
        return new ResponseEntity<RespResult>(respResult, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<RespResult> addGroup(Integer gId, Integer uId) {
        RespResult respResult = groupService.addGroup(gId, uId);
        return new ResponseEntity<RespResult>(respResult, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<RespResult> exitGroup(Integer gId, Integer uId) {
        RespResult respResult = groupService.exitGroup(gId, uId);
        return new ResponseEntity<RespResult>(respResult, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<RespResult> sendGroupMessage(Integer gId, Integer uId, String content, String time) {
        RespResult respResult = groupService.sendGroupMessage(gId, uId, content, time);
        return new ResponseEntity<RespResult>(respResult, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<RespResult> receiveGroupMessage(Integer gId) {
        RespResult respResult = groupService.receiveGroupMessage(gId);
        return new ResponseEntity<RespResult>(respResult, HttpStatus.OK);
    }
}
