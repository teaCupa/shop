<template>
    <div>
        <y-shelf title="支付成功" style="text-align: center">
            <div slot="right">返回</div>

            <div slot="content" class="content">
                <p>恭喜你支付成功，总共花费 <span class="price"><em style="font-size: 18px">¥</em>
                    {{price}}</span> 元</p>
                <div style="margin-top: 20px;">
                    <router-link to="/user">
                        <button style="width: 150px;height: 50px;line-height: 48px;font-size: 20px">
                            查看订单</button>
                    </router-link>

                    <router-link to="/home">
                        <button  style="width: 150px;height: 50px;line-height: 48px;font-size: 20px">
                            继续选购</button>
                    </router-link>

                </div>
            </div>

        </y-shelf>
    </div>
</template>

<script>
    import YShelf from '@/components/common/Shelf'
    export default {
        name: "PaySuccess",
        components: {
            YShelf,
        },
        data(){
            return{
                price:11
            }
        }
    }
</script>

<style scoped>
    .content {
        padding: 150px 0;
        font-size: 30px;
    }

    span.price {
        color: #d44d44;
        font-weight: 700;
        line-height: 20px;
        text-align: right;
    }
</style>
