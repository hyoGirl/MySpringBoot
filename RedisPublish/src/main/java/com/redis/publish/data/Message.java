package com.redis.publish.data;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * @Auther: xulei
 * @Date: 2019/7/19 0019 19:11
 * @Description:
 */
@Data
public class Message implements Serializable {


    private static final long serialVersionUID = -1522956047957499223L;

    private String name;
    private String msg;

}
