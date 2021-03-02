package org.yh.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.yh.shop.common.ResponseEntity;
import org.yh.shop.service.SecKillService;
import org.yh.shop.utils.CurdUtil;
import org.yh.shop.utils.DateUtil;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author: yh
 * @Date: 2021/2/22
 * @Description:
 */

@RestController
@RequestMapping("/secKill")
public class SecKillController {

    @Autowired
    SecKillService secKillService;

    @GetMapping("/find")
    ResponseEntity findSecKillGoods(String time){
        return CurdUtil.find(secKillService.findSecKillGoods(time));
    }

    /**
     * 获取秒杀频道 2021022410,2021022412...
     * @return
     */
    @GetMapping("/getChannel")
    ResponseEntity getChannel(){
        List<String>list = new ArrayList<>();
        List<Date> dateMenus = DateUtil.getDateMenus();
        for (Date dateMenu : dateMenus) {
            list.add(DateUtil.date2str(dateMenu,"yyyyMMddHH"));
        }
        return CurdUtil.find(list);
    }

}
