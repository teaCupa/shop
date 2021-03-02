package org.yh.shop.config_security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.yh.shop.model.SysUser;
import org.yh.shop.service.SysUserService;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @Author: yh
 * @Date: 2020/12/22
 * @Description:
 */

@Service
public class JwtUserDetailsService implements UserDetailsService {
   @Autowired
   private SysUserService sysUserService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        SysUser user=sysUserService.loadUserByUsername(s);
        if(user ==null)
            throw new UsernameNotFoundException("用户不存在");
        // 用户权限列表，根据用户拥有的权限标识与如 @PreAuthorize("hasAuthority('sys:menu:view')") 标注的接口对比，决定是否可以调用接口
        Set<String> permissions = sysUserService.findPermissions(user.getName());
        //GrantedAuthorityImpl::new 访问GrantedAuthorityImpl类的构造方法
        List<GrantedAuthority> grantedAuthorities = permissions.stream().map(GrantedAuthorityImpl::new).collect(Collectors.toList());
        return new JwtUserDetails(user.getName(),user.getPassword(),grantedAuthorities);
    }
}
