<template>
    <div v-show="this.$route.path !=='/login'">
        <div class="mr-container">
            <div style="display: flex">
                <div class="topMessage">
                    <a @click="show('/login')" style="color: #929692;cursor: pointer" v-if="!user">亲，请登录</a>
                    <span v-else style="color: red;cursor:none">{{user.nickname}}，欢迎您 </span>
                    <a href="javascript:" @click="show('/register')"
                       style="text-decoration:none;color: red; margin-left: 20px;" v-show="!user">免费注册</a>
                </div>
                <div style="margin-left: 55%;padding-top: 16px">
                    <router-link to="/" style="color:red;text-decoration:none">
                        商城首页
                    </router-link>
                </div>

                <div style="margin-left: 10px;padding-top: 16px">
                    <span style="font-size: 14px;color:#929692"><i class="fa fa-user-o"></i></span>
                    <el-dropdown @command="handleCommand">
                        <span class="el-dropdown-link" style="color:#929692"> 个人中心</span>
                        <el-dropdown-menu slot="dropdown">
                            <el-dropdown-item command="logout">
                                <i class="fa fa-sign-out"></i>注销登录</el-dropdown-item>
                        </el-dropdown-menu>
                    </el-dropdown>
                </div>
                <div style="margin-left: 10px;padding-top: 16px;cursor: pointer">
                    <a @click="show('/cart')">
                        <span style="color:#e5efe5"><i class="fa fa-shopping-cart"></i></span>
                        <span style="color:#929692"> 购物车</span>
                        <span class="circleNum" v-if="cartList.length">
                        {{ cartList.length }}</span>
                    </a>
                </div>
            </div>
        </div>
    </div>

</template>

<script>
    // import {mapActions, mapGetters, mapState} from "vuex";

    export default {
        name: 'Header',
        computed: {
            // ...mapState([
            //     'user',//this.user映射为this.$store.state.user
            //     'isLogin'//this.isLogin映射为this.$store.state.isLogin
            // ]),
            user() {
                return this.$store.state.user.user;
            },
            cartList() {
                return this.$store.state.cart.cartList;
            },
        },


        methods: {
            show: function (path) {
                if (path === '/cart') {
                    if (this.user == null) {//用户未登录
                        this.$router.push({path: '/login'});//跳转到登录页面
                        return
                    }
                }
                this.$router.push({path: path});
            },
            handleCommand(command) {
                if (command === 'logout') {
                    this.logout()
                }
            },
            logout: function () {
                if (confirm('确定退出登录吗？')) {
                    this.$store.dispatch('logoutAction');//执行退出登录操作
                    this.$store.commit('emptyCart')
                    // this.$router.push({path:'/'});//跳转到主页
                }
            }
        },
        //在created()之后，mounted能够加载dom节点,而created执行时dom节点尚未加载
        created() {
            if(this.user){    //处理刷新数据丢失问题
                this.getRequest('/basket?userId=' + this.user.id).then(resp => {
                    if (resp) {
                        this.$store.commit('setCart', resp.data)
                    }
                })
            }
            var that = this
            this.$bus.on('loadCart', function (e) {
                that.getRequest('/basket?userId=' + that.user.id).then(resp => {
                    if (resp) {
                        that.$store.commit('setCart', resp.data)
                    }
                })
            })
        },
        beforeDestroy() {
            this.$bus.off('loadCart');
        }
    }
</script>
<style scoped lang="scss">

    .mr-container {
        margin-left: -1%;
        margin-right: -1%;
        margin-top: -1%;
        background-color: #292929;
    }


    .topMessage {
        padding: 10px 16px;
        margin-left: 10%;
        height: 35px;
        line-height: 35px;
    }

    .circleNum {
        display: inline-block;
        width: 16px;
        height: 16px;
        line-height: 16px;
        text-align: center;
        border-radius: 50%;
        background: #ff5500;
        color: #fff;
        font-size: 12px;
    }

    .el-dropdown-link {
        cursor: pointer;
        color: #409EFF;
    }

    .el-icon-arrow-down {
        font-size: 10px;
    }

</style>

