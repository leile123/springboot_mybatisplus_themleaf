package cn.star.clean.entity;

import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

/**
 *
 */
@Data
@TableName("abc")
public class Abc extends SuperEntity{

    private static final long serialVersionUID = 1L;

    private String name;

    private Integer sex;


}
