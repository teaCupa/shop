<template>
    <div class="container">
            <ul>
                <li class="item_group">
                    <h4>订单服务</h4>
                    <div>
                        <a href="javascript:void(0)" target="_blank" style="color: #606060">购买指南</a>
                    </div>
                    <div>
                        <a href="javascript:void(0)" target="_blank" style="color: #606060">送货政策</a>
                    </div>
                </li>
                <li class="item_group">
                    <h4>服务支持</h4>
                    <div>
                        <a href="javascript:void(0)" target="_blank" style="color: #606060">门店维修</a>
                    </div>
                    <div>
                        <a href="javascript:void(0)" target="_blank" style="color: #606060">售后服务</a>
                    </div>
                </li>
                <li class="item_group">
                    <h4>媒体</h4>
                    <div>
                        <a href="javascript:void(0)" target="_blank" style="color: #606060">新闻动态</a>
                    </div>
                    <div>
                        <a href="javascript:void(0)" target="_blank" style="color: #606060">视频图片</a>
                    </div>
                </li>
                <li class="item_group">
                    <h4>关注我们</h4>
                    <div>
                        <a href="javascript:void(0)" target="_blank" style="color: #606060">新浪微博</a>
                    </div>
                    <div>
                        <a href="javascript:void(0)" target="_blank" style="color: #606060">微信公众号</a>
                    </div>
                </li>
            </ul>
        <div style="float: right;margin-top: 100px;margin-right: 20px; height: 80px">Copyright © 2021 github.com/teaCupa</div>
    </div>
</template>

<script>
    export default {
        name: "Foot"
    }
</script>

<style scoped>
    .container {
        display: block;
        background-color: #cecece;
        border-top: 1px solid #e6e6e6;
    }

    ul li {
        list-style: none;
    }

    .item_group {
        float: left;
        margin-right: 90px;
        line-height: 2;
    }

    a {
        text-decoration: none;
    }
</style>
