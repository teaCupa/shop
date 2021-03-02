<template>
    <div>
        <div  v-for="(item,index) in products" style="float: left;width: 22%;
                  text-align: center;margin-top: 16px;background: #fff;
                  border: 1px solid #dddee1;padding: 16px;border-radius: 6px">
            <img :src="item.pic"></img>
            <p style="height: 32px" v-html="item.name"></p>
            <p>￥<span>{{item.price}}</span></p>
           <p style="height: 30px">{{item.brief}}</p>
        </div>
    </div>
</template>

<script>
    export default {
        name: "Elasticsearch",
        data(){
            return{
               keywords: this.$route.query.keywords,
                products: ''
            }
        },
        mounted(){
            this.getRequest('/es/search?keywords='+this.keywords).then(resp=>{
                if(resp){
                    this.products=resp.data
                }
            })
        }
    }
</script>

<style scoped>

</style>
