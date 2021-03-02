package org.yh.shop.elasticsearch.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.yh.shop.common.ResponseEntity;
import org.yh.shop.elasticsearch.service.ElasticSearchService;
import org.yh.shop.utils.CurdUtil;

/**
 * @Author: yh
 * @Date: 2021/3/1
 * @Description:
 */

@RestController
@RequestMapping("/es")
public class ElasticSearchController {
    @Autowired
    ElasticSearchService elasticSearchService;

    @GetMapping("/import")
    void imporProduct(){
        elasticSearchService.save();
    }

    /**
     * elastic java api 搜索
     * @param keywords
     * @return
     */
    @GetMapping("/search")
    ResponseEntity find(String keywords,Integer pageNum,Integer pageSize){
        return CurdUtil.find(elasticSearchService.find(keywords,pageNum,pageSize));
    }
}
