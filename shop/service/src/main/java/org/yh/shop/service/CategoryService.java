package org.yh.shop.service;

import org.yh.shop.model.Category;
import org.yh.shop.model.vo.CategoryList;

import java.util.List;

/**
 * @Author: yh
 * @Date: 2020/12/24
 * @Description:
 */


public interface CategoryService {

    List<Category> findAll();

    int save(Category record);

    int delete(List<Category> categories);

    List<CategoryList> findNav();
}
