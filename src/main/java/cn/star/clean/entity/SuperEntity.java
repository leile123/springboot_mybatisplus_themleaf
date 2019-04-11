package cn.star.clean.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableLogic;
import com.baomidou.mybatisplus.enums.FieldFill;
import java.io.Serializable;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;


/**
 * 演示实体父类
 */
@Getter
@Setter
public class SuperEntity implements Serializable {

    public static final String DB_ID = "id";
    public static final String DB_DELETED = "deleted";
    public static final String DB_CREATE_USER = "create_user";
    public static final String DB_UPDATE_USER = "update_user";
    public static final String DB_UPDATE_TIME = "update_time";
    public static final String DB_CREATE_TIME = "create_time";


    /**
     * 主键ID , 这里故意演示注解可以无
     */
    private Long id;

    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    /**
     * 创建人
     */
    @TableField(fill = FieldFill.INSERT)
    private String createUser;
    /**
     * 更新时间
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;
    /**
     * 更新人
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private String updateUser;

    /**
     * 是否删除1-逻辑删除，默认为0
     */
    @TableLogic
    private Integer deleted;


}
