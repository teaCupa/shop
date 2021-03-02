package org.yh.shop.common;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class PageBean implements Serializable {
     private List<?> data;  //data是按照page,size要求检索的数据，比如1,10检索前10条
     private Long total;  //数据库中符合要求的总记录数，用于前端分页插件
}