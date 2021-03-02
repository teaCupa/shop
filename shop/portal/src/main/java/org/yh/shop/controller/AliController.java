package org.yh.shop.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.yh.shop.common.ResponseEntity;
import org.yh.shop.common.alipay.PayForm;
import org.yh.shop.service.PayService;

import java.io.IOException;

/**
 * @Author: yh
 * @Date: 2020/12/5
 * @Description:
 *       参考博客 https://blog.csdn.net/weixin_44520739/article/details/89214609
 *       支付宝沙箱网站 https://open.alipay.com/platform/home.htm
 */

@RestController
public class AliController {

    @Autowired
    PayService payService;

    @PostMapping("/alipay")
    public ResponseEntity alipay(@RequestBody PayForm payForm) throws IOException {
        return payService.alipay(payForm);
    }
}

