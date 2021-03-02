<template>
    <div>
      <div v-if="productDetail && sku">
          <div class="product">
            <div class="product-image">
                <img :src="sku.skuPic">
            </div>
            <div class="product-info">
                <h1>{{ productDetail.product.name }}</h1>
                <h4>{{ productDetail.product.brief }}</h4>
                <h4>{{ sku.skuProperties }}</h4>
                <div class="product-cost">¥ {{ sku.skuPrice }}</div>
                <div class="list-control-filter" v-for="item in productDetail.propVos">
                    <span style="font-weight: bold">{{item.propName}}</span>
                    <button :id="item.propNameId+':'+item2.propValueId"
                            class="list-control-filter-item"
                            v-for="item2 in item.propValues"
                            @click="handleFilterValue(item2.propValueId,item.propNameId)">{{ item2.propValue}}
                    </button>
                </div>
                <div>
                    <span class="product-add-cart" @click="handleAddToCart">加入购物车</span>
                    <span class="product-add-cart buyCss" @click="buyNow">立即支付</span>
                </div>
                <div v-show="showSecKillQueryMsg">{{secKillQueryMsg}}</div>
            </div>
        </div>
        <div class="product-desc">
            <h2>产品介绍</h2>
            <img v-for="url in imgArray" :src="url">
        </div>
        <div class="product-desc">
            <h2>相关推荐</h2>
        </div>
     </div>
    </div>
</template>
<script>
    export default {
        data() {
            return {
                // 获取路由中的参数
                id: parseInt(this.$route.params.id),
                isSecKill: this.$route.query,
                productDetail: null,
                sku: null,
                tempSkuVos: [],
                imgArray: [],
                filterPropValue: new Map(),
                showSecKillQueryMsg:false,
                secKillQueryMsg:'',
                queryOrderStatusCount:0
            }
        },
        computed: {
            user() {
                return this.$store.state.user.user
            },
            cartList(){
                return this.$store.state.cart.cartList
            }
        },
        methods: {
            filterSpuSkuRelVos(filterPropValue, srcArr) {
                let _spuSkuRelVos = [...srcArr];   //深拷贝？
                filterPropValue.forEach(function (propValueId, propNameId) {
                    let tempArr = []
                    _spuSkuRelVos.forEach(item => {
                        let temp=[],flag = true
                        for(let i=0;i<item.spuSkuRels.length;i++){
                            let elem=item.spuSkuRels[i]
                            //过滤
                            if(elem.propNameId === propNameId && elem.propValueId !== propValueId){
                                flag=false;
                                break;
                            }
                            temp.push(elem)
                        }
                        if (flag) {
                            item.spuSkuRels=temp
                            tempArr.push(item)
                        }
                    })
                    _spuSkuRelVos = tempArr
                })
                console.log('#', _spuSkuRelVos)
                return _spuSkuRelVos
            },
            // 加入购物车
            handleAddToCart() {
                if (this.user == null) {
                    if (confirm('请您先登录')) {
                        this.$router.push({path: '/login', query: {id: '/product/' + this.id}})
                    }
                    return
                }
                //是否是秒杀订单
                if(this.isSecKill.tag==='secKill'){
                     this.makeSecKillOrder()
                     return
                }

                let flag=this.cartList.find((item)=>{   //filter->return [...]  find->{}
                    return item.skuId===this.sku.skuId
                })
                if(!flag){   //flag===undefined
                   this.addCartToDb(this.sku)
                }
                this.$message.success('该商品添加成功，去购物车看看吧！')
            },
            addCartToDb(sku){
                let cartJson={userId:'',skuId:''}
                cartJson.userId=this.user.id
                cartJson.skuId=sku.skuId
                this.postRequest('/basket',cartJson).then(resp=>{
                    if(resp){
                        this.$bus.emit('loadCart')
                    }
                })
            },
            //准备创建秒杀订单
            makeSecKillOrder(){
                let cartJson={userId:'',spuId:'',skuId:'',secKillChannel:''}
                cartJson.userId=this.user.id
                cartJson.spuId=this.id
                cartJson.skuId=this.sku.skuId
                cartJson.secKillChannel=this.isSecKill.secKillChannel
                var that=this
               this.postRequest('/secKillOrder/add',cartJson).then(res=>{
                   if(res){
                       // this.$message.success('已下单！')
                       //强制后台返回类型为String而不是long
                       //否则导致bug 1365188733028093952 -> 1365188733028094000
                       let orderTrancId=res.data
                       //查询秒杀订单状态
                       that.querySecKillOrderStatus(orderTrancId)
                   }
               })
            },
            querySecKillOrderStatus(orderTrancId){
                var that=this
                this.getRequest('/secKillOrder/query?orderTrancId='+orderTrancId).then(res=>{
                   if(res){
                       this.queryOrderStatusCount++     //查询状态次数+1
                       if(this.queryOrderStatusCount>5){
                           this.showSecKillQueryMsg =true
                           this.secKillQueryMsg='秒杀失败！'
                           return
                       }
                       this.showSecKillQueryMsg =true
                       console.log('>>'+res.data)
                       if(res.data==="0"){
                           this.secKillQueryMsg="正在秒杀排队中..."
                           //注意区分setInterval和setTimeout。前者是循环执行，后者是延迟执行(不循环)
                           setTimeout(that.querySecKillOrderStatus(orderTrancId),1000)
                       }else{
                           this.secKillQueryMsg="秒杀成功！"
                           //跳转到秒杀订单页
                           //这种方式跳转后url中含有?, 会导致不能跳转到支付接口
                           // this.$router.replace('/secKillOrder?orderTrancId='+orderTrancId)
                           this.$router.replace('/secKillOrder/'+orderTrancId)
                       }
                   }
               })
            },
            //获取推荐的图片
            getRecommendImgs() {
                //数据库中多个图片url以@作分隔符
                if(this.productDetail.product.imgs!=null &&this.productDetail.product.imgs!=='')
                        this.imgArray = this.productDetail.product.imgs.split('@')
            },
            handleFilterValue(propValueId, propNameId) {
                this.filterPropValue.set(propNameId, propValueId)
                console.log(this.filterPropValue)
                this.productDetail.propVos.forEach(function (val, index, attr) {
                    if (val.propNameId === propNameId) {
                        val.propValues.forEach(function (val2) {
                            document.getElementById(propNameId + ':' + val2.propValueId).style.backgroundColor = ''
                        })
                    }
                })
                document.getElementById(propNameId + ':' + propValueId).style.backgroundColor = '#ffe77f'
                this.tempSkuVos = this.filterSpuSkuRelVos(this.filterPropValue, this.productDetail.spuSkuRelVos)
                this.sku = this.tempSkuVos[0]
            },
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
                        console.log('productBuydoc: {}',document.body)
                        document.forms[0].setAttribute('target', '_blank') // 新开窗口跳转
                        document.forms[0].submit()
                    }
                })
            }

        },
        mounted() {
            this.getRequest('/product/detail?id=' + this.id).then(resp => {
                if (resp) {
                    this.productDetail = resp.data
                    console.log('productDetail:',this.productDetail)
                    this.sku = this.productDetail.spuSkuRelVos[0]
                    this.getRecommendImgs();
                }
            })
        }
    }
</script>
<style scoped>

    .list-control-filter-item {
        margin: 12px 12px;
        padding: 2px 8px;
        cursor: pointer;
        border: 1px;
        border-radius: 1%;
    }

    .product {
        margin: 32px;
        padding: 32px;
        background: #f9f9f9;
        border: 1px solid #dddee1;
        border-radius: 10px;
        overflow: hidden;
    }

    .product-image {
        width: 42%;
        height: 550px;
        float: left;
        text-align: center;
    }

    .product-image img {
        height: 100%;
    }

    .product-info {
        width: 50%;
        padding: 60px 0 250px; /*上60px*/
        height: 160px;
        float: left;
        text-align: center;
    }

    .product-cost {
        color: #f2352e;
        margin: 8px 0;
    }

    .product-add-cart {
        display: inline-block;
        padding: 8px 28px;
        margin: 8px 4px;
        background: #2d8cf0;
        color: #fff;
        border-radius: 4px;
        cursor: pointer;
    }
    .buyCss{
        background-color: #b82220;
    }

    .product-desc {
        background: #f9f9f9;
        margin: 16px;
        padding: 16px;
        border: 1px solid #dddee1;
        border-radius: 10px;
        text-align: center;
    }

    .product-desc img {
        display: block;
        width: 50%;
        margin: 16px auto;
        padding: 16px;
        border-bottom: 1px solid #dddee1;
    }
</style>
