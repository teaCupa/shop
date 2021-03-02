package org.yh.shop.utils;


import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;


/**
 * Security相关操作
 * @author Louis
 * @date Jan 14, 2019
 */
public class SecurityUtils {

	/**
	 * 系统登录认证
	 */
//	public static Authentication login(HttpServletRequest request, String username, String password, AuthenticationManager authenticationManager) {
//		// 执行登录认证过程
//		UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username, null);
//		Authentication authentication = authenticationManager.authenticate(token);
//	    // 认证成功存储认证信息到上下文
//	    SecurityContextHolder.getContext().setAuthentication(authentication);
//		return token;
//	}

	
	/**
	 * 获取当前认证的用户名
	 * @return
	 */
	public static Authentication getAuthentication() {
		if(SecurityContextHolder.getContext() == null) {
			return null;
		}
		return SecurityContextHolder.getContext().getAuthentication();
	}
	
}
