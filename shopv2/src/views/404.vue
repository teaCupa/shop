<template>
    <div class="container">
     <div style="display: block;width: 205px;height: 205px">
        <img src="@/assets/images/icon.wrong.png">
        <h2>抱歉,页面加载失败</h2>
        <button class="btn-back" @click="$router.replace('/')">返回首页</button>
     </div>
    </div>
</template>

<script>
    export default {
        name: "404"
    }
</script>

<style scoped>
    .container{
        margin: 112px auto 220px;  /*左右auto*/
        max-width: 380px;
        height: 340px;
        text-align: center;
    }

    .btn-back{
        padding: 6px 10px;
        border: 1px solid #d0d0d0;
        border-radius: 6px;
        font-weight: 700;
        font-size: 14px;
        color: #666;
        margin: 0 auto;
        cursor: pointer;
        transition: all .15s ease-out;
        background-color: transparent;
    }
</style>
