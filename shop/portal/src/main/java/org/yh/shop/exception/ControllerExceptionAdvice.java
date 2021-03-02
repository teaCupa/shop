package org.yh.shop.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.yh.shop.common.ResponseEntity;

/**
 * @Author: yh
 * @Date: 2021/1/16
 * @Description:
 */

@RestControllerAdvice
@Slf4j
public class ControllerExceptionAdvice {
    @ExceptionHandler({GlobalException.class})
    public ResponseEntity globalExceptionHandler(GlobalException e){
        log.error(e.getMessage(),e);
        return new ResponseEntity(e.getCode(),e.getMsg());
    }
}
