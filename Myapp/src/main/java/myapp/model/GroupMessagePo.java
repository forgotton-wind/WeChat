package myapp.model;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import java.util.Date;

@ApiModel(value = "群消息表")
@Data

public class GroupMessagePo {
    Integer id;
    String content;
    Date time;
    Integer uId;
    Integer gId;
    Integer type;
}
