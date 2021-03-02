### Customize configuration
See [Configuration Reference](https://cli.vuejs.org/config/).

### node-sass 镜像
npm i node-sass --sass_binary_site=https://npm.taobao.org/mirrors/node-sass/

## font-awesome
npm install font-awesome
在main.js导入 
fa开头，见Header.vue的<span style="font-size: 24px"><i class="fa fa-user-o"></i></span>

## 安装SCSS,用于编写页面样式
npm install sass-loader node-sass -dev
在页面的style标签把lang设置为scss

## 父子组件
父组件 定义 <childComponent name='zs'></childComponent>
传参name为字符串'zs' 
子组件接收  props:['name'] ，使用 <p>{{name}}</p>
另一种方式 props:{user:Object}类型也可为字符串,数组，Number等

## router-view 
把header组件放到App.vue下成为公共的组件，路由跳转时header组件存在

## store.js 拆封为module
只有state字段如store.state.user.isLogin, store.state.cart.cartList
需要加上特定的module名user、cart。其他getters等不用。

 ### css 左右两侧布局 float:left; width:50% 

### 组件通信 
utils包下定义一个vue-bus.js，在main.js里use,login函数里调用emit事件
header组件里监听on以及摧毁事件off

### 组件slot的使用，见Shelf.vue及PaySuccess.vue
