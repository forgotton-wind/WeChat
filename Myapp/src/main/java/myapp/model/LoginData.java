package myapp.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2021-06-16T00:55:45.832+08:00")

@Data
public class LoginData {
    @JsonProperty("uid")
    private Integer uid = null;
    @JsonProperty("userAccount")
    private String userAccount = null;
}
