package org.yh.shop.log;

import lombok.Data;

import java.lang.reflect.Method;

/**
 * @Author: yh
 * @Date: 2020/12/29
 * @Description:
 */

@Data
public class WebLog {
    private String ip;
    private String uri;
    private String url;
    private String username;
    private Long startTime;
    private Long endTime;
    private Method method;
    private Object[] parameter;
    private Object result;
}
