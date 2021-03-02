import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'
import Login from "../views/user/Login";

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'Home',
    meta:{title:'首页'},
    component: Home
  }, {
    path: '/login',
    name: 'Login',
    meta:{title:'登录'},
    component: (resolve) => require(['@/views/user/Login.vue'], resolve)
  }, {
    path: '/register',
    name: 'Register',
    meta:{title:'注册'},
    component: (resolve) => require(['@/views/user/Register.vue'], resolve)
  }, {
    path: '/cart',
    meta: {
      title: '购物车'
    },
    component: (resolve) => require(['@/components/Cart.vue'], resolve)
  },{
    path: '/list',
    meta: {
      title: '商品列表'
    },
    component: (resolve) => require(['@/components/main/FineProductList.vue'], resolve)
  },
  {
    path: '/product/:id',
    meta: {
      title: '商品详情'
    },
    component: (resolve) => require(['@/views/ProductBuy.vue'], resolve)
  },{
    path: '/product/cate/:id',
    meta: {
      title: '商品种类'
    },
    component: (resolve) => require(['@/views/ProductNavCategory.vue'], resolve)
  },{
    path: '/secKillOrder/:orderTrancId',
    meta: {
      title: '秒杀订单'
    },
    component: (resolve) => require(['@/views/SecKillOrderDetail.vue'], resolve)
  },
  {
    path:'/paySuccess',
    meta:{
      title:'支付成功'
    },
    component: (resolve) => require(['@/components/PaySuccess.vue'], resolve)
  },{
    path:'/elasticsearch',
    meta:{
      title:'搜索'
    },
    component: (resolve) => require(['@/components/Elasticsearch.vue'], resolve)
  },
  {
    path:'*',
    meta:{
      title:'404'
    },
    component: (resolve) => require(['@/views/404.vue'], resolve)
  }
]

const router = new VueRouter({
  routes
})

router.beforeEach((to, from, next) => {
  window.document.title = to.meta.title;
  next();
});

router.afterEach((to, from, next) => {
  window.scrollTo(0, 0);   //回到顶部
});

export default router
