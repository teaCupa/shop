<template>
    <div v-show="list.length">
        <div class="list-control">
            <h4 style="box-shadow: 0 1px 1px rgba(0,0,0,.2);padding-bottom: 8px">精选商品</h4>
            <div class="list-control-order">
                <span>排序：</span>
                <span
                        class="list-control-order-item"
                        :class="{on: order === ''}"
                        @click="handleOrderDefault">默认</span>
                <span
                        class="list-control-order-item"
                        :class="{on: order === 'sales'}"
                        @click="handleOrderSales">
                    销量
                    <template v-if="order === 'sales'">↓</template>
                </span>
                <span
                        class="list-control-order-item"
                        :class="{on: order.indexOf('cost') > -1}"
                        @click="handleOrderCost">
                    价格
                    <template v-if="order === 'cost-asc'">↑</template>
                    <template v-if="order === 'cost-desc'">↓</template>
                </span>
            </div>
        </div>
        <Product v-for="item in filteredAndOrderedList" :info="item" :key="item.id"></Product>
        <div class="product-not-found" v-show="!filteredAndOrderedList.length">暂无相关商品</div>
    </div>
</template>

<script>
    import Product from "../components/product/Product";

    export default {
        name: "ProductNavCategory",
        data(){
            return{
                // 获取路由中的参数
                categoryId: parseInt(this.$route.params.id),
                filterColor: '',
                order: ''
            }
        },
        components: { Product },
        computed: {
            list () {
                return this.$store.state.product.productList;
            },
            filteredAndOrderedList () {
                let list = [...this.list];  //赋值
                // 排序
                if (this.order !== '') {
                    if (this.order === 'sales') {
                        list = list.sort((a, b) => b.saleNum - a.saleNum);
                    } else if (this.order === 'cost-desc') {
                        list = list.sort((a, b) => b.price - a.price);
                    } else if (this.order === 'cost-asc') {
                        list = list.sort((a, b) => a.price - b.price);
                    }
                }
                return list;
            }
        },
        methods: {
            handleFilterColor (color) {
                if (this.filterColor === color) {
                    this.filterColor = '';
                } else {
                    this.filterColor = color;
                }
            },
            handleOrderDefault () {
                this.order = '';
            },
            handleOrderSales () {
                this.order = 'sales';
            },
            handleOrderCost () {
                if (this.order === 'cost-desc') {
                    this.order = 'cost-asc';
                } else {
                    this.order = 'cost-desc';
                }
            }
        },
        mounted () {
            this.getRequest('/product/find').then(resp=>{
                if(resp){
                    this.$store.dispatch('setProductList',resp.data)
                }
            })
        }
    }
</script>

<style scoped>
    .list-control{
        background: #fff;
        border-radius: 6px;
        margin: 16px;
        padding: 16px;
        box-shadow: 0 1px 1px rgba(0,0,0,.2);
    }
    .list-control-filter{
        margin-bottom: 12px;
    }
    .list-control-filter-item,
    .list-control-order-item {
        cursor: pointer;
        display: inline-block;
        border: 1px solid #e9eaec;
        border-radius: 4px;
        margin-right: 6px;
        padding: 2px 6px;
    }
    .list-control-filter-item.on,
    .list-control-order-item.on{
        background: #f2352e;
        border: 1px solid #f2352e;
        color: #fff;
    }
    .product-not-found{
        text-align: center;
        padding: 32px;
    }
</style>
