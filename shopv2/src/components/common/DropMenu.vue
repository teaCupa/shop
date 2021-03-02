<template>
    <div>
    <ul style="display: flex;" v-if="type===1 && isShow">
        <li v-for="c2 in data">
            <div  style="height: 264px;display: flex;flex-direction: column;">
                <div style="margin: 0 0 8px 40px;font-weight: 700;font-size: 14px;color: #929292">{{c2.c2Name}}</div>
                <ul class="category-container">
                    <li  v-for="item in c2.products">
                        <router-link :to="'/product/Cate/'+item.id" style="text-decoration: none">
                            <a style="display: flex;">
                                <img :src="item.pic" style="margin-right: 10px" width="40" height="40">
                                <p style="font-weight: 700;color: #000000;margin-top: 10px">{{item.name}}</p>
                            </a>
                        </router-link>
                    </li>
                </ul>
            </div>
        </li>
    </ul>

        <div style="justify-content: center" v-if="type===2 && isShow">
            <ul style="display: flex;justify-content: center;">
                <li style="margin-right: 30px;">
                    <a style="width: 126px;display: block;">
                        <img src="@/assets/images/ad1.png" width="126" height="126">
                        <p style="font-weight: 700;text-align: center;">name</p>
                        <p style="color: #d44d44;text-align: center;">price</p>
                    </a>
                </li>
            </ul>
        </div>
    </div>
</template>

<script>
    export default {
        name: "dropMenu",
        props: {
            data: Array ,
            isShow: Boolean,
            type: Number   //1 菜单  2 图片
        }
    }
</script>

<style scoped>

    .category-container{
        display: flex;
        flex-flow: column wrap;
        min-height: 210px;   /*重要*/
    }

    li{
        list-style:none;
        display: flex;
        justify-content: space-between;
        margin-bottom: 10px;
    }

    a{
        cursor: pointer;
        margin-right: 30px;
        font-weight: 700;
        background-color: transparent;
    }
</style>
