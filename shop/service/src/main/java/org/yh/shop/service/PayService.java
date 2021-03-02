package org.yh.shop.service;

import org.yh.shop.common.ResponseEntity;
import org.yh.shop.common.alipay.PayForm;

/**
 * @Author: yh
 * @Date: 2020/12/5
 * @Description:
 */


public interface PayService {
    ResponseEntity alipay(PayForm payForm);
}
