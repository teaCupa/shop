package org.yh.shop.common;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: yh
 * @Date: 2020/11/22
 * @Description:
 */

@Data
public class ResponseEntity implements Serializable {
    private int status;
    private String msg;
    private Object data;

    public ResponseEntity() {
    }

    public ResponseEntity(int status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    private ResponseEntity(ResponseStatus rs) {
        this.status = rs.getStatus();
        this.msg = rs.getMsg();
        this.data=null;
    }

    private ResponseEntity(ResponseStatus rs,Object data) {
        this.status = rs.getStatus();
        this.msg = rs.getMsg();
        this.data=data;
    }


    public static ResponseEntity ok(Object data){
        return new ResponseEntity(ResponseStatus.SUCCESS,data);
    }
    public static ResponseEntity ok(ResponseStatus rs,Object data){
        return new ResponseEntity(rs,data);
    }
    public static ResponseEntity ok(ResponseStatus rs){
        return new ResponseEntity(rs);
    }

    public static ResponseEntity error(ResponseStatus rs){
        return new ResponseEntity(rs);
    }
    public static ResponseEntity error(String msg){
        ResponseEntity responseEntity = new ResponseEntity();
        responseEntity.setMsg(msg);
        responseEntity.setStatus(407);
        return responseEntity;
    }

}
