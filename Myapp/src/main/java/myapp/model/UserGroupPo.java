package myapp.model;

import io.swagger.annotations.ApiModel;
import lombok.Data;

@ApiModel(value = "群聊人员表")
@Data

public class UserGroupPo {
    Integer id;
    Integer uId;
    Integer gId;
}
