package org.yh.shop.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * user
 * @author 
 */
@Data
public class User implements Serializable {
    private Long id;

    private String nickname;

    /**
     * 真实姓名
     */
    private String name;

    private String password;

    private String email;

    private String phone;

    private String payPassword;

    /**
     * 头像
     */
    private String pic;

    /**
     * M男 或 F 女
     */
    private String sex;

    private Date birthDate;

    private Byte status;
    private Date createDate;
    private Date updateDate;


    private static final long serialVersionUID = 1L;
}