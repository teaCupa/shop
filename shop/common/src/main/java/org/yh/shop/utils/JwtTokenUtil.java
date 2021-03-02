package org.yh.shop.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: yh
 * @Date: 2020/12/29
 * @Description:
 */


public class JwtTokenUtil {
    private static final String USERNAME="name";
    private static final String CREATEDAt="createdAt";
    private static final String SECRET="abcdefg";
    /**
     * 有效期30分钟
     */
//    private static final long EXPIRE_TIME = 30 * 60 * 1000;
    private static final long EXPIRE_TIME = 2 * 60 * 1000;

    public static String generateToken(Authentication authentication) {
        UserDetails principal = (UserDetails) authentication.getPrincipal();
        Map<String,Object> map= new HashMap<>(2);
        map.put(USERNAME,principal.getUsername());
        map.put(CREATEDAt,new Date());
        return geneToken(map);
    }

    private static String geneToken(Map<String,Object>map){
        Date expirationDate=new Date(System.currentTimeMillis()+EXPIRE_TIME);
//         Jwts.builder().claim("authorities","role").setSubject(USERNAME,"zs")
        // .claim使用系统的JwtMap<String,Object>; setClaims使用自定义的Map<String,Object>
        return Jwts.builder().setClaims(map).setExpiration(expirationDate)
                 .signWith(SignatureAlgorithm.HS512, SECRET)
                .compact();
    }


    /**
     * 从令牌中获取数据声明
     *
     * @param token 令牌
     * @return 数据声明
     */
    private static Claims getClaimsFromToken(String token) {
        Claims claims;
        try {
            claims = Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token).getBody();
        } catch (Exception e) {
            claims = null;
        }
        return claims;
    }

    /**
     * 验证令牌
     * @param token
     * @return
     */
    public static Boolean validateToken(String token) {
        if(token==null ||"".equals(token)){
            return false;
        }
        Claims claims = getClaimsFromToken(token);
        if(claims==null){
            return false;
        }
        String username = ((String) claims.get(USERNAME));
        if(SecurityUtils.getAuthentication()==null){
            return false;
        }
        UserDetails principal = (UserDetails) SecurityUtils.getAuthentication().getPrincipal();
        return principal.getUsername().equals(username);
    }

    /**
     * 刷新令牌
     * @param token
     * @return
     */
    public static String refreshToken(String token) {
        String refreshedToken;
        try {
            Claims claims = getClaimsFromToken(token);
            claims.put(CREATEDAt, new Date());
            refreshedToken = geneToken(claims);
        } catch (Exception e) {
            refreshedToken = null;
        }
        return refreshedToken;
    }

    /**
     * 判断令牌是否过期
     *
     * @param token 令牌
     * @return 是否过期
     */
    public static Boolean isTokenExpired(String token) {
        try {
            Claims claims = getClaimsFromToken(token);
            Date expiration = claims.getExpiration();
            return expiration.before(new Date());
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * 获取请求token
     * @param request
     * @return
     */
    public static String getToken(HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        String tokenHead = "Bearer ";
        if(token == null ||"".equals(token)) {
            return null;
        } else if(token.contains(tokenHead)){
            token = token.substring(tokenHead.length());
        }
        return token;
    }
}
