package org.yh.shop.exception;

import lombok.Data;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 自定义异常
 * @author Louis
 * @date Jan 12, 2019
 */
@Data
public class GlobalException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
    private String msg;
    private int code = 500;
    
    public GlobalException(String msg) {
		super(msg);
		this.msg = msg;
	}
	
	public GlobalException(String msg, Throwable e) {
		super(msg, e);
		this.msg = msg;
	}
	
	public GlobalException(String msg, int code) {
		super(msg);
		this.msg = msg;
		this.code = code;
	}
	
	public GlobalException(String msg, int code, Throwable e) {
		super(msg, e);
		this.msg = msg;
		this.code = code;
	}

	
}
