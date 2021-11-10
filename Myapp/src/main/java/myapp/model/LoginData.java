package myapp.model;

import lombok.Data;
import java.util.List;

@Data
public class LoginData {
    UserPo userPo;
    List<UserPo> linkManList;
    List<GroupPo> groupPoList;
}
