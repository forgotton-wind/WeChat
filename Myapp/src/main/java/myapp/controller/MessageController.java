package myapp.controller;

import myapp.model.UserPo;
import myapp.service.UserService;
import myapp.util.RespResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.annotation.WebFilter;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2021-09-02T00:36:41.717+08:00")

@WebFilter(filterName = "caseInsensitiveFilter", urlPatterns = "/*")
@RestController

public class MessageController extends BaseController implements MessageApi {
    @Autowired
    private MessageService messageService;

    @Override
    public ResponseEntity<RespResult> messageTransmit(Integer mFromId, Integer mToId, String message) {
        RespResult respResult = messageService.userLogin(mFromId, mToId, message);
        return new ResponseEntity<RespResult>(respResult, HttpStatus.OK);
    }
}
