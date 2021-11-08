package myapp.controller;

import myapp.service.MessageService;
import myapp.util.RespResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2021-09-02T00:36:41.717+08:00")

@RestController
public class MessageController extends BaseController implements MessageApi {
    @Autowired
    private MessageService messageService;

    @Override
    public ResponseEntity<RespResult> messageTransmit(Integer mFromId, Integer mToId, String content, Integer type, String time) {
        RespResult respResult = messageService.messageTransmit(mFromId, mToId, content, type, time);
        return new ResponseEntity<RespResult>(respResult, HttpStatus.OK);
    }

    @Override
    public  ResponseEntity<RespResult> messageInquire(Integer id) {
        RespResult respResult = messageService.messageInquire(id);
        return new ResponseEntity<RespResult>(respResult, HttpStatus.OK);
    }

    @Override
    public  ResponseEntity<RespResult> setMessageReaded(Integer fromId, Integer toId) {
        RespResult respResult = messageService.setMessageReaded(fromId, toId);
        return new ResponseEntity<RespResult>(respResult, HttpStatus.OK);
    }
}
