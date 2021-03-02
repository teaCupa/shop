package org.yh.shop.model.vo;

import lombok.Data;
import org.yh.shop.model.C2Children;

import java.util.List;

/**
 * @Author: yh
 * @Date: 2020/12/27
 * @Description: 前端Nav对应的数据结构
 */


@Data
public class CategoryList {

    private String name;  //一级种类名，如手机数码，图书教育等
    public List<C2Children> c2Childrens;
    private int type;    //显示的类型， 1为菜单型，2为图片型


}
