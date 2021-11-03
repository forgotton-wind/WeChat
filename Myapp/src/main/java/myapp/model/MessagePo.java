package myapp.model;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import java.util.Date;

@ApiModel(value = "消息表")
@Data

public class MessagePo {
    private Integer id;
    private String content;
    private Integer status;
    private Date time;
    private Integer typeId;
    private Integer fromId;
    private Integer toId;
}
