<template>
    <div class="cart">
        <div>
            <div class="cart-header-title">购物清单</div>
        <el-table
                ref="multipleTable"
                :data="cartList"
                tooltip-effect="dark"
                @selection-change="handleSelectionChange">
            <el-table-column
                    type="selection"
                    width="55">
            </el-table-column>
            <el-table-column label="商品信息" width="760px">
                <template slot-scope="scope">
                   <div style="text-align: left">
                     <img width="30px" height="30px" style="margin-top:0 " :src="scope.row.sku.skuPic"/>
                     <span style="margin-left: 20px">{{ scope.row.sku.skuName }}</span>
                   </div>
                </template>
            </el-table-column>
            <el-table-column label="单价" width="120">
                <template slot-scope="scope">
                    ¥ {{ scope.row.sku.skuPrice }}
                </template>
            </el-table-column>
            <el-table-column label="数量" align="center" width="120">
                <template slot-scope="scope">
                    <span class="cart-control-minus" @click="handleCount(scope.row, -1)">-</span>
                    {{ scope.row.num }}
                    <span class="cart-control-add" @click="handleCount(scope.row, 1)">+</span>
                </template>
            </el-table-column>
            <el-table-column label="小计" align="center" width="120">
                <template slot-scope="scope">
                    ¥ {{ scope.row.sku.skuPrice * scope.row.num }}
                </template>
            </el-table-column>
            <el-table-column label="删除" align="center">
                <template slot-scope="scope">
                    <span class="cart-control-delete" @click="handleDelete(scope.row)">删除</span>
                </template>
            </el-table-column>
        </el-table>
            <div class="cart-empty" v-if="!cartList.length">购物车为空</div>
        </div>
        <div class="cart-promotion" v-show="cartList.length">
            <span>使用优惠码：</span>
            <input type="text" v-model="promotionCode">
            <span class="cart-control-promotion" @click="handleCheckCode">验证</span>
        </div>
        <div class="cart-footer" v-show="cartList.length">
            <div class="cart-footer-desc">
                共计 <span>{{ countAll }}</span> 件商品
            </div>
            <div class="cart-footer-desc">
                应付总额 <span>¥ {{ costAll - promotion }}</span>
                <br>
                <template v-if="promotion">
                    （优惠 <span>¥ {{ promotion }}</span>）
                </template>
            </div>
            <div class="cart-footer-desc">
                <div class="cart-control-order" @click="handleOrder">现在结算</div>
            </div>
        </div>
    </div>
</template>
<script>
    export default {
        computed: {
            user() {
                return this.$store.state.user.user
            },
            cartList(){
                return this.$store.state.cart.cartList
            },
            countAll () {
                let count = 0;
                this.multipleSelection.forEach(item => {
                    count += item.num;
                });
                return count;
            },
            costAll () {
                let cost = 0;
                this.multipleSelection.forEach(item => {
                    cost += item.sku.skuPrice * item.num;
                });
                return cost;
            }
        },
        data() {
            return {
                promotionCode: '',
                promotion: 0,
                multipleSelection:[],
                payForm: {
                    out_trade_no: '',
                    subject: '产品名称',
                    total_amount: 10,
                    body: ''
                }
            }
        },

        methods: {
            handleCount(row, count) {
                if (count < 0 && row.num === 1) return;
                row.num += count
                //写入db
                this.putRequest('/basket?basketId='+row.basketId+'&num='
                    +row.num)
            },
            handleDelete(row) {
                //写入db
                this.deleteRequest('/basket?basketId='+row.basketId).then(resp=>{
                    if(resp)
                        this.$store.commit('deleteCart', row.basketId);
                })
            },
            handleDeleteMore(rows){
                let ids=[]
                rows.forEach(row=>{
                    ids.push(row.basketId)
                })
                this.deleteRequest('/basket/more',ids).then(resp=>{
                    if(resp){
                        this.$store.dispatch('buy',this.multipleSelection)
                    }
                })
            },
            handleCheckCode() {
                if (this.promotionCode === '') {
                    window.alert('请输入优惠码');
                    return;
                }
                if (this.promotionCode !== 'Vue.js') {
                    window.alert('优惠码验证失败');
                } else {
                    this.promotion = 500;
                }
            },
            handleOrder() {
                this.postRequest('/alipay', this.payForm).then(resp => {
                    if (resp) {
                        //应该放到支付成功后处理
                        this.handleDeleteMore(this.multipleSelection)
                        // 添加之前先删除一下，如果单页面，页面不刷新，添加进去的内容会一直保留在页面中，二次调用form表单会出错
                        // const divForm = document.getElementsByTagName('div')
                        // if (divForm.length) {
                        //     //移除当前页面div
                        //     document.body.removeChild(divForm[0])
                        // }
                        const div = document.createElement('div')
                        div.innerHTML = resp.data // data就是接口返回的form 表单字符串
                        document.body.appendChild(div)
                        document.forms[0].setAttribute('target', '_blank') // 新开窗口跳转
                        document.forms[0].submit()
                    }
                })
            },

            handleSelectionChange(val) {
                this.multipleSelection = val;
            }
        }
    }
</script>
<style scoped>
    .cart {
        margin: 32px;
        width: 86%;
        background: #fff;
        border: 1px solid #dddee1;
        border-radius: 10px;
    }

    .cart-header-title {
        padding: 16px 32px;
        border-bottom: 1px solid #dddee1;
        border-radius: 10px 10px 0 0;
        background: #f8f8f9;
    }


    .cart-empty {
        text-align: center;
        padding: 32px;
    }

    .cart-header-main div {
        text-align: center;
        float: left;
        font-size: 14px;
    }

    div.cart-info {
        width: 50%;
        text-align: left;
    }


    .cart-content-main {
        padding: 0 32px;
        height: 60px;
        line-height: 60px;
        text-align: center;
        border-bottom: 1px dashed #e9eaec;
        overflow: hidden;
    }

    .cart-content-main div {
        float: left;
    }

    .cart-content-main img {
        width: 40px;
        height: 40px;
        position: relative;
        top: 10px;
    }

    .cart-control-minus,
    .cart-control-add {
        display: inline-block;
        margin: 0 4px;
        width: 24px;
        height: 24px;
        line-height: 22px;
        text-align: center;
        background: #f8f8f9;
        border-radius: 50%;
        box-shadow: 0 1px 1px rgba(0, 0, 0, .2);
        cursor: pointer;
    }

    .cart-control-delete {
        cursor: pointer;
        color: #2d8cf0;
    }

    .cart-promotion {
        padding: 16px 32px;
    }

    .cart-control-promotion,
    .cart-control-order {
        display: inline-block;
        padding: 8px 32px;
        border-radius: 6px;
        background: #2d8cf0;
        color: #fff;
        cursor: pointer;
    }

    .cart-control-promotion {
        padding: 2px 6px;
        font-size: 12px;
        border-radius: 3px;
    }

    .cart-footer {
        padding: 32px;
        text-align: right;
    }

    .cart-footer-desc {
        display: inline-block;
        padding: 0 16px;
    }

    .cart-footer-desc span {
        color: #f2352e;
        font-size: 20px;
    }
</style>
