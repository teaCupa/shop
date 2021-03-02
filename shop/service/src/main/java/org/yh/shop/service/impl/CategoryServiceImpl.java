package org.yh.shop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yh.shop.dao.CategoryDao;
import org.yh.shop.model.C2Children;
import org.yh.shop.model.Category;
import org.yh.shop.model.Product;
import org.yh.shop.model.vo.CategoryList;
import org.yh.shop.service.CategoryService;
import org.yh.shop.service.ProductService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author: yh
 * @Date: 2020/12/24
 * @Description:
 */

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryDao categoryDao;
    @Autowired
    ProductService productService;

    @Override
    public List<Category> findAll() {
        List<Category>categories= new ArrayList<>();
        List<Category> cates=categoryDao.findAll();
        for (Category cate : cates) {
            if(cate.getParentId()==0){
                cate.setLevel(0);
                categories.add(cate);
            }
        }
        findChildren(categories,cates,1);
        return categories;
    }

    /**
     * 设置父种类对应的子种类children
     * @param categories 父种类
     * @param cates    子种类
     * @param level  层级
     */
    private void findChildren(List<Category> categories, List<Category> cates,int level) {
        if(categories==null)
            return;
        for (Category category : categories) {
            List<Category>children= new ArrayList<>();
            for (Category cate : cates) {
                if(cate.getParentId().equals(category.getId())){
                    cate.setParentName(category.getName());
                    cate.setLevel(level);
                    children.add(cate);
                }
            }
            category.setChildren(children);
            findChildren(children,cates,level+1);
        }
    }

    @Override
    public int save(Category record) {
        if(record.getId()==null || (record.getId()==0)){  //添加
            record.setCreateDate(new Date());
            record.setStatus(true);
            categoryDao.insertSelective(record);
            //插入的是产品，同时插入到product表
            if(record.getLevel()==2){
                productService.insertByCate(record);
            }
            return 1;
        }
        return categoryDao.updateByPrimaryKeySelective(record);
    }

    @Override
    public int delete(List<Category> categories) {
        for (Category category : categories) {
            categoryDao.deleteByPrimaryKey(category.getId());
        }
        return 1;
    }

    @Override
    public List<CategoryList> findNav() {
        List<CategoryList> categoryLists=new ArrayList<>();
        List<Category> cates=findAll();
        for (Category cate : cates) {
           CategoryList categoryList = new CategoryList();
           List<C2Children>c2Childrens= new ArrayList<>();
           categoryList.setName(cate.getName());  //设置一级种类名
            for (Category child : cate.getChildren()) {
                C2Children c2Children = new C2Children();
                c2Children.setC2Name(child.getName());  //设置二级种类名
                List<Product>products =new ArrayList<>();
                for (Category c2 : child.getChildren()) {
                    Product product = new Product();
                    product.setId(Long.valueOf(c2.getId()));
                    product.setName(c2.getName());
                    product.setPic(c2.getCategoryPic());
                    products.add(product);
                }
                c2Children.setProducts(products);     //设置具体的产品
                c2Childrens.add(c2Children);
            }
            categoryList.setC2Childrens(c2Childrens);
            categoryLists.add(categoryList);
        }
        return categoryLists;
    }

}
