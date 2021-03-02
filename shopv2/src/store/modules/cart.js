export default {
    state:{
        cartList: []
    },
    mutations:{
        // 添加到购物车
        addCart (state, obj) {
            state.cartList.push(obj)
        },
        // 修改商品数量
        // editCartCount (state, payload) {
        //     const product = state.cartList.find(item => item.id === payload.id);
        //     product.count += payload.count;
        // },
        // 删除商品
        deleteCart (state, id) {
            const index = state.cartList.findIndex(item => item.basket === id);
            state.cartList.splice(index, 1);
        },
        // 清空购物车
        emptyCart (state,list) {
            var res=[]
            var set=new Set(list)
            state.cartList.forEach(e=>{
                if(!set.has(e)){
                    res.push(e)
                }
            })
            state.cartList = res;
        },
        setCart(state,data){
            state.cartList= data
        }
    },

    actions:{
        // 购买
        buy (context,list) {
            // 真实环境应通过 ajax 提交购买请求后再清空购物列表
            return new Promise(resolve=> {
                setTimeout(() => {
                    context.commit('emptyCart',list);
                    resolve();
                }, 500)
            });
        }
    }
}
