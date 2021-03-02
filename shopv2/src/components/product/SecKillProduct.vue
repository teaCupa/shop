<template>
    <div class="product">
        <div class="product-main">
            <img :src="info.smallPic">
            <h4>{{ info.name }}</h4>
            <div class="secKillGoodsInfo">
                <span style="padding: 30px 0 0 30px;display: block;position: relative;line-height: 1;"></span>
                <i style="font-size: 24px; color: #e01222;font-family: arial;line-height: 1;display: inline-block;min-width: 50px;">
                    <em>¥</em>{{info.costPrice}}</i>
                <span style="font-size: 16px;color: #999;margin-left: 4px">
                    ¥<del>{{info.price}}</del>
                </span>
                <span style="display: block;margin-top: 3px">
                    <i style="line-height: 1px">已售{{getProportion(info)}}%</i>
                    <i class="process_inner">
                        <b class="process_completed" :style="'width:'+getProportion(info)+'%'"></b>
                    </i>
                </span>
                <a :href="'/#/product/' + info.spuId+'?tag=secKill&secKillChannel='+secKillChannel" target="_blank" class="btn">立即抢购</a>
            </div>
        </div>
    </div>
</template>

<script>
    export default {
        name: "SecKillProduct",
        props: {
            info: Object,
            secKillChannel: String
        },
        data() {
            return{
            }
        },
        methods:{
            getProportion(info){
                return Math.floor(info.num*100/info.stockCount)
            }
        }
    }
</script>

<style scoped>
    .product{
        width: 25%;
        float: left;
    }
    .product-main{
        display: block;
        margin: 16px;
        padding: 16px;
        border: 1px solid #dddee1;
        border-radius: 6px;
        overflow: hidden;
        background: #fff;
        text-align: center;
        position: relative;
    }
    .product-main img{
        width: 100%;
    }
    h4{
        color: #222;
        overflow: hidden;
        text-overflow: ellipsis;
        white-space: nowrap;
    }
    .product-main:hover h4{
        color: #0070c9;
    }
    .secKillGoodsInfo{
        overflow: hidden;
        text-align: left;
        height: 99px;
        display: block;
        border-top: 1px solid #f6f6f6;
        margin-top: -35px;
        left: 0;
        width: 290px;
    }
    .btn{
        color: #fff;
        height: 40px;
        line-height: 40px;
        font-size: 16px;
        display: block;
        top: 340px;
        right: 0;
        margin: auto 0;
        width: 80px;
        text-align: center;
        position: absolute;
        background: #df0021;
    }
    a{
        text-decoration: none;
    }
    .process_inner{
        width: 88px;
        height: 8px;
        background: #e6e6e6;
        display: inline-block;
        position: relative;
        overflow: hidden;
        margin-left: 5px;
        -moz-border-radius: 8px;
        border-radius: 8px;
    }
    .process_completed{
        background: #df0021;
        width: 40%;
        position: absolute;
        left: 0;
        top: 0;
        height: 8px;
        -moz-border-radius: 8px 0 0 8px;
        border-radius: 8px 0 0 8px;
    }
</style>
