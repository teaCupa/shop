<template>
    <div>
        <Banner/>
        <HotActivity/>
        <List/>
    </div>
</template>

<script>
    import HotActivity from "../components/main/SecKillActivity";
    import Banner from "../components/main/Carousel";
    import List from "../components/main/FineProductList";
    export default {
        name: "Main",
        components:{List, Banner,HotActivity}
    }
</script>

<style scoped>

</style>
