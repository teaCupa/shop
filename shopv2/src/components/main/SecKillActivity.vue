<template>
    <!--热门活动，秒杀商品 -->
    <div style="margin-left: 2%;">
        <div>
            <div style="display: inline-block">
            <h4 class="block">秒杀商品</h4>
                <div class="iconfont">
                    <span @click="prevPic" :class="{noneStyle:index===0}"><i class="fa fa-angle-left" ></i></span>
                    &nbsp;<span @click="nextPic" :class="{noneStyle:index>=itemListArray.length-1}">
                    <i class="fa fa-angle-right"></i></span></div>
            </div>
            <div>
             <div class="secKillCountDown">
                 <a href="#" target="_blank">
                     <div style="width: 100%;text-align: center;font-size: 30px;
                        font-weight: 700;margin-top: 31px;color: white">商城秒杀</div>
                     <div style="margin-top: 50px;font-size: 14px;text-align: center;color: white">
                         <strong>{{secKillStartTime}}</strong>点场 倒计时
                     </div>
                     <span>
                         <span class="timeUnit-hour_minute">{{hour}}</span>
                         <span class="timeUnit-hour_minute">{{minute}}</span>
                         <span class="timeUnit-second">{{second}}</span>
                     </span>
                     <span id="overText" style="position:absolute;left:30px;bottom: 46px;font-size: 16px;color: #e1ff29"></span>
                 </a>
             </div>
                <div style="margin-top: -16px">
            <el-carousel trigger="click" height="400px" ref="cardShow" :autoplay="false" arrow="never" indicator-position="none">
                <el-carousel-item v-for="itemList in itemListArray">
                    <SecKillProduct v-for="item in itemList" :info="item" :secKillChannel="secKillChannel" :key="item.id"></SecKillProduct>
                </el-carousel-item>
            </el-carousel>
            </div>
            </div>
        </div>
    </div>
</template>

<script>
    import format from "../../utils/formatArray";
    import SecKillProduct from "../product/SecKillProduct";

    export default {
        name: "HotActivity",
        components:{SecKillProduct},
        data(){
            return{
                itemListArray:[],
                index:0,
                timer:'',
                secKillChannel:'',
                secKillStartTime:"",
                hour:"00",
                minute: "00",
                second: "00"
            }
        },
        mounted() {
            this.getRequest('/secKill/getChannel').then(resp=>{
                if(resp){
                    this.secKillChannel=resp.data[0]
                }
                //获取秒杀商品
                this.getRequest('/secKill/find?time='+this.secKillChannel).then(resp=>{
                    if(resp){
                        this.itemListArray=format(resp.data)
                    }
                })
                this.secKillStartTime=this.secKillChannel.substring(8)+":00"
            })

            var date=new Date()
            this.getRemainTime(date)
            this.countDown()
        },
        methods:{
            prevPic(){
                this.index--
                this.$refs.cardShow.prev()
            },
            nextPic(){
                this.index++
                this.$refs.cardShow.next()
            },
            countDown(){
                var that=this
                var _document=document
                this.timer=setInterval(function (){
                    if(that.second>0){
                        that.second--
                        if(that.second<10){
                            that.second='0'+that.second
                        }
                    }
                    else if(that.minute>0){
                        that.minute--
                        if(that.minute<10){
                            that.minute='0'+that.minute
                        }
                        that.second=59
                    }else if(that.hour>0){
                        that.hour--
                        if(that.hour<10)
                             that.hour ='0'+that.hour
                        that.minute=59
                        that.second=59
                    } else{
                        clearInterval(that.timer)
                        _document.getElementById('overText').innerHTML='该场次秒杀已结束！'
                    }
                },1000)
            },
            getRemainTime(date){
                var hour=date.getHours()
                hour -= hour%2
                //下一个秒杀时段 10:00-12:00，12:00-14:00
                if(date.getSeconds()>0){
                     this.second =60-date.getSeconds()
                     this.minute =59-date.getMinutes()
                     this.hour =hour +2-1
                }else{
                    if(date.getMinutes()>0){
                        this.minute=60-date.getMinutes()
                        this.hour= hour+2-1
                    }else{
                        this.hour=hour +2
                    }
                }
            }

        }
    }
</script>

<style scoped>
    .block{
        width: 1440px;
        border: 1px solid #dddee1;    /*边界*/
        border-radius: 10px;
        background-color: #f6f6f6;
        box-shadow: 0 1px 1px rgba(0,0,0,.2);
        padding: 12px;
        margin-bottom: 0;
    }

    .secKillCountDown{
        position: relative;
        float: left;
        width: 190px;
        margin-top: 42px;
        height: 300px;
        color: #fff;
        background-color: #e83632;
        background-image: url(//misc.360buyimg.com/mtd/pc/index_2019/1.0.0/assets/img/4a15d88….png);
        background-size: contain;
        background-position: 50%;
    }

    .timeUnit-hour_minute{
        position: relative;
        float: left;
        left: 30px;
        top: 50px;
        width: 30px;
        height: 30px;
        text-align: center;
        background-color: #2f3430;
        margin-right: 20px;
        color: white;
        font-size: 20px;
    }
    .timeUnit-second{
        position: relative;
        float: left;
        left: 30px;
        top: 50px;
        width: 30px;
        height: 30px;
        text-align: center;
        background-color: #2f3430;
        margin-right: 20px;
        color: white;
        font-size: 20px;
    }
    .timeUnit-hour_minute:after{
        content: ":";
        display: block;
        position: absolute;
        right: -20px;
        font-weight: bolder;
        font-size: 18px;
        width: 20px;
        height: 100%;
        top: 0;
    }
    .timeUnit-second:after{
        content: "";
        display: block;
        position: absolute;
        right: -20px;
        font-weight: bolder;
        font-size: 18px;
        width: 20px;
        height: 100%;
        top: 0;
    }

    .iconfont{
        float: right;
        color: #4e4e4e;
        font-size: 30px;
        cursor: pointer;
        margin-top: -44px;
        padding-right: 40px;
    }

    .noneStyle{
        color: #c4c4c4;
        pointer-events: none;
    }

    a{
        text-decoration: none;
    }

</style>
