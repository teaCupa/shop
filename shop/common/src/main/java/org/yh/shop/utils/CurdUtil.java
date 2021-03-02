package org.yh.shop.utils;

import org.yh.shop.common.ResponseEntity;
import org.yh.shop.common.ResponseStatus;

/**
 * @Author: yh
 * @Date: 2020/11/22
 * @Description:  增删改查，划分为2类：查询和更新操作
 */


public class CurdUtil{
    public static ResponseEntity find(Object object){
         if(object !=null){
             return ResponseEntity.ok(ResponseStatus.SUCCESS,object);
         }
         return ResponseEntity.error(ResponseStatus.FINDERROR);
    }

    public static ResponseEntity update(long res){
         if(res >0){
             return ResponseEntity.ok(ResponseStatus.SUCCESS);
         }
         return ResponseEntity.error(ResponseStatus.UPDATEFAIL);
    }

}
