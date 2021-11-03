package myapp.model;

import io.swagger.annotations.ApiModel;
import lombok.Data;

@ApiModel(value = "消息表")
@Data

public class FriendPo {
    private Integer id;
    private String name;
    private Integer uId;
    private Integer fId;
}
