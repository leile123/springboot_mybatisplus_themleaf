package cn.star.clean.dto;

import java.io.Serializable;
import lombok.Data;

/**
 * @Description TODO
 * @Author leile
 * @Date 2019/4/1 下午4:08
 */
@Data
public class PageDTO implements Serializable {

    private int current = 1;
    private int pageSize = 10;
}