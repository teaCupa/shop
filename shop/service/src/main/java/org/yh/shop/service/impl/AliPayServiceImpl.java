package org.yh.shop.service.impl;

import com.alibaba.fastjson.JSON;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yh.shop.common.ResponseEntity;
import org.yh.shop.common.alipay.PayForm;
import org.yh.shop.dao.TOrderDao;
import org.yh.shop.model.TOrder;
import org.yh.shop.service.PayService;
import org.yh.shop.utils.CurdUtil;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

import static org.yh.shop.common.alipay.AliPayConfig.*;

/**
 * @Author: yh
 * @Date: 2020/12/5
 * @Description:
 */

@Service
public class AliPayServiceImpl implements PayService {
    @Autowired
    TOrderDao orderDao;
    @Override
    public ResponseEntity alipay(PayForm payForm) {
        AlipayClient alipayClient = new DefaultAlipayClient(GATEWAY_URL, APP_ID, APP_PRIVATE_KEY, FORMAT, CHARSET, ALIPAY_PUBLIC_KEY, SIGN_TYPE);
        AlipayTradePagePayRequest request = new AlipayTradePagePayRequest();
        //在公共参数中设置回跳和通知地址
        request.setReturnUrl(RETURN_URL);
        request.setNotifyUrl(NOTIFY_URL);

        //生成随机商户订单号
        payForm.setOut_trade_no(UUID.randomUUID().toString());
        //写入数据库
        TOrder order = new TOrder();
        order.setOrderId(11);
        order.setOrderNumber(payForm.getOut_trade_no());
        order.setActualPrice(BigDecimal.valueOf(payForm.getTotal_amount()));
        order.setOrderName(payForm.getSubject());
        order.setOrderDesc(payForm.getBody());
        order.setPayType(1);
        order.setStatus(0);
        order.setCreateDate(new Date());
        orderDao.insert(order);

        request.setBizContent(JSON.toJSONString(payForm));
        String res = null;
        try {
            res = alipayClient.pageExecute(request).getBody(); // 调用SDK生成表单
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        return CurdUtil.find(res);
    }
}
