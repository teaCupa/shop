<template>
   <div>
       <div style="text-align: center">
       <h3>秒杀订单</h3>
       <table border="1" cellpadding="3" cellspacing="0" style="width: 60%;margin:auto">
           <tr>
               <td>订单交易单号</td>
               <td>{{secKillOrder.transactionId}}</td>
           </tr>
           <tr>
               <td>订单创建时间</td>
               <td>{{secKillOrder.createTime}}</td>
           </tr>
           <tr >
               <td>订单金额</td>
               <td>{{secKillOrder.money}} 元</td>
           </tr>
       </table>
       </div>
        <div style="margin-left: 20%;margin-top: 30px">
         <span>添加收货信息</span>
         <i class="fa fa-plus-square-o" @click="showAddressInfo=true"
            style="font-size: 20px;position: absolute;margin-top: 2px;margin-left: 2px;color: #2dff2a"></i>
        </div>

       <el-form v-show="showAddressInfo"  :model="secKillOrder" label-width="100px" style="width: 32%;margin-left: 30%">
           <el-form-item label="收货地址">
               <el-input v-model="secKillOrder.receiverAddress"></el-input>
           </el-form-item>
           <el-form-item label="收货电话">
               <el-input v-model="secKillOrder.receiverMobile"></el-input>
           </el-form-item>
           <el-form-item label="收货人姓名">
               <el-input v-model="secKillOrder.receiver"></el-input>
           </el-form-item>
           <el-form-item>
               <el-button type="primary" @click="showAddressInfo=false">立即创建</el-button>
               <el-button @click="showAddressInfo=false">取消</el-button>
           </el-form-item>
       </el-form>
        <el-button type="primary" @click="buyNow" style="margin-left: 70%">立即支付</el-button>
   </div>
</template>

<script>

    import format from "../utils/formatArray";

    export default {
        name: "SecKillOrder",
        data(){
            return{
                orderTrancId: this.$route.params.orderTrancId,
                secKillOrder: {},
                showAddressInfo: false
            }
        },
        methods:{
             buyNow(){
                 var payForm={
                     out_trade_no: '', subject: '产品名称',
                     total_amount: 10, body: ''
                 }
                 this.postRequest('/alipay', payForm).then(resp => {
                     if (resp) {
                         const div = document.createElement('div')
                         div.innerHTML = resp.data // data就是接口返回的form 表单字符串
                         document.body.appendChild(div)
                         console.log('doc: {}',document.body)
                         //有个乌龙，该页面定义了 el-form，所以下面用forms[1]而不是forms[0]
                         document.forms[1].setAttribute('target', '_blank') // 新开窗口跳转
                         document.forms[1].submit()
                     }
                 })
             }
        },
        mounted(){
            this.getRequest('/secKillOrder/find?orderTrancId='+this.orderTrancId).then(resp=>{
                if(resp){
                    this.secKillOrder=resp.data
                    this.secKillOrder.createTime=this.secKillOrder.createTime
                }
            })
        }
    }
</script>

<style scoped>

</style>
