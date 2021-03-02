<template>
    <div>
        <Nav/><Main/><Foot/>
    </div>
</template>

<script>
    // @ is an alias to /src
  import Nav from '../components/home/Nav'
  import Main from './Main'
    import Foot from "../components/foot/Foot";

    export default {
        name: 'Home',
        components: {Nav,Main,Foot},
    }
</script>
<style>
</style>
