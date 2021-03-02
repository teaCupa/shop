package org.yh.shop.dao;

import org.apache.ibatis.annotations.Param;
import org.yh.shop.model.Product;

import java.util.List;

public interface ProductDao {
    int deleteByPrimaryKey(Long id);

    int insert(Product record);

    int insertSelective(Product record);

    Product selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Product record);

    int updateByPrimaryKey(Product record);

    List<Product> selectAll();

    List<Product> getProductsByPage(@Param("page") Integer page, @Param("size") Integer size,@Param("name") String name);

    Long getProductsTotal(String name);

    List<Product> selectAlls();

//    List<Product> getProductsByAdSearch(@Param("page")Integer page,@Param("size") Integer size,@Param("name") String name,
//                                       @Param("categoryName") String categoryName,@Param("startDate") Date startDate,@Param("endDate") Date endDate);

//    Long getTotalByAdSearch(@Param("name")String name,@Param("categoryName") String categoryName,,@Param("startDate") Date startDate,@Param("endDate") Date endDate);
}