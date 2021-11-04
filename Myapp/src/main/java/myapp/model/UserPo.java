package myapp.model;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import java.util.Date;

@ApiModel(value = "用户表")
@Data
public class UserPo {
    private Integer uid;
    private String userAccount;
    private String password;
    private Integer state;
    private String gravatar;
    private String nickName;
    private String name;
    private String sex;
    private Date birthday;
    private String email;
    private String schoolName;
    private String city;
    private String bloodType;
    private String phone;
}
