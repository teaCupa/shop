 ### productDao.xml
 select  p.*,brand_name,color_name
    from product p, brand b,color c where p.brand_id=b.brand_id and p.color_id=c.color_id
    而不是 select <include refid="Base_Column_List" />,brand_name .....
    因为表brand,color主键字段都为id,导致查询的id重复
 另外，通过关联id如brand_id查询表brand关联字段(brand_name)时
 1 建立vo实体 
 2 用association关联brand对象   
 
 ### 数据库表命名导致bug(不要命名为order,使用t_order避免重名)
 
 jwt 相比于cookie-session： 移动端不支持cookie，适合采用jwt认证
 session会给服务端造成压力，而且对于分布式系统，jwt更合适。
 
 传统的 session+cookie 方案用户点击注销，服务端清空 session 即可，因为状态
 保存在服务端。但 jwt 的方案就比较难办了，因为 jwt 是无状态的，服务端通过
 计算来校验有效性。没有存储起来，所以即使客户端删除了 jwt，但是该jwt还是在
 有效期内，只不过处于一个游离状态。
 分析下痛点：注销变得复杂的原因在于jwt 的无状态。仅仅清空客户端的 cookie，
 这样用户访问时就不会携带 jwt，服务端就认为用户需要重新登录。这是一个典型的
 假注销，对于用户表现出退出的行为，实际上这个时候携带对应的 jwt 依旧可以
 访问系统。
 
 ### jwt登录异常以及portal模块登录异常
 主要是登录接口302重定向导致 
 解决方式 http.csrf().disable()
 
 #### 报错required a bean of type 'org.yh.shop.service.UserService' that could not be found
 ![](https://gitee.com/noyyh/picgo_image/raw/master/img/20201222121643.png)
 多模块项目包名不一致导致不能扫描注解对象  org.yh.admin -> org.yh.shop
 
 ### tinyint(1) 即boolean类型
 不要用mybatis自动生成的Byte类型，而是改为Boolean类型
 
 ### mybatis的xml的property即实体属性，column为列别名（避免多个表的字段名重复）
 
 ### portal改了ProductController启动报错 
  解决：maven clean 清理class 重新编译启动
  
## druid监控工具，见portal模块#druidconfig

## 日志admin模块resource目录下定义了log4j.properties，测试方法在admin模块的Test目录下，显然生效了  


![](https://gitee.com/noyyh/picgo_image/raw/master/img/20210226145029.png)
后台返回id类型(比如仅仅返回一个数字)给前端最好返回String类型，不要用Long类型。id可能发生精度丢失
  
  
 
 
 
 