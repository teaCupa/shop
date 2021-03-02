<template>
  <div id="app">
      <Header/>
    <!-- 路由匹配到的组件将显示在这里 -->
    <router-view/>
  </div>
</template>

<script>
  import Header from "./components/home/Header";

  export default {
    name: 'Home',
    components: {Header}
  }
</script>

<style>
</style>
