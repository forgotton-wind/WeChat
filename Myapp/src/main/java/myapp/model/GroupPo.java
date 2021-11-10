package myapp.model;

import io.swagger.annotations.ApiModel;
import lombok.Data;

@ApiModel(value = "群聊表")
@Data

public class GroupPo {
    Integer id;
    String name;
}
