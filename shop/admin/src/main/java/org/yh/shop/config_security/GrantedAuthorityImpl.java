package org.yh.shop.config_security;

import org.springframework.security.core.GrantedAuthority;

/**
 * @Author: yh
 * @Date: 2020/12/23
 * @Description: 权限
 */


public class GrantedAuthorityImpl implements GrantedAuthority {

    private String authority;

    public GrantedAuthorityImpl(String authority) {
        this.authority = authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    @Override
    public String getAuthority() {
        return authority;
    }
}
