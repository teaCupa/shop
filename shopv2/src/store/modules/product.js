import getFilterArray from "../../utils/filterArray";
export default {
    state:{
        productList: [],
    },

    getters:{
       // brands: state=> {
       //    const brands= state.productList.map(item=>item.brand.brandName);
       //     return getFilterArray(brands);
       // }
    },

    mutations:{
        // 添加商品列表
        setProductList (state, data) {
            state.productList = data;
        },
    },

    actions:{
        // 请求商品列表
        setProductList (context,product_data) {
            context.commit('setProductList', product_data);
        },
    }

}
