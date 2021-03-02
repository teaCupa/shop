package org.yh.shop.model.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: yh
 * @Date: 2020/11/26
 * @Description:
 */

@Data
public class LoginVo implements Serializable {
    private String username;
    private String password;
}
