package org.yh.shop.model;

import lombok.Data;

import java.util.List;

/**
 * @Author: yh
 * @Date: 2020/12/27
 * @Description: 作为CategoryList的属性
 */

@Data
public class C2Children {
    private String c2Name; //二级种类名,如手机
    private List<Product> products;
}
