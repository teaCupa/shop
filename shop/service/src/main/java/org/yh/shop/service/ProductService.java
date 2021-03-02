package org.yh.shop.service;

import org.yh.shop.common.PageBean;
import org.yh.shop.model.Category;
import org.yh.shop.model.Product;
import org.yh.shop.model.vo.ProductVo;

import java.util.List;

/**
 * @Author: yh
 * @Date: 2020/11/22
 * @Description:
 */

public interface ProductService  {

    List<Product> getProduct();

    PageBean getProductByPage(Integer page, Integer size, String name);


    ProductVo getProductVoById(Integer id);


    void insertByCate(Category record);

    int save(Product product);

    List<Product> getAllProduct();
}
