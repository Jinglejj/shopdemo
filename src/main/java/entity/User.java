package entity;

import com.oracle.webservices.internal.api.databinding.DatabindingMode;
import lombok.Data;
import lombok.ToString;

import java.util.Date;
import java.util.List;

@Data
@ToString
public class User {

    private Integer id;
    private String username;
    private String password;
    private String nickName;
    private Date createTime;

}