package cn.star.clean.entity;

import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;


@Data
@TableName("star_basis_user")
public class User extends SuperEntity {

    private static final long serialVersionUID = 1L;

    private String username;

    private String password;

    private String email;

    private String mobel;


}
