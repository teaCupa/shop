export default {
    state: {
        user: JSON.parse(sessionStorage.getItem('user')),  //定义用户名
    },
    getters: {
        length: function (state) {
            return state.List.length;
        },
    },
    mutations: {
        login: function (state, user) {
            state.user = user;//修改状态
            sessionStorage.setItem('user', JSON.stringify(user));//保存用户名
        },
        logout:function (state) {
            state.user=null;
            sessionStorage.removeItem('user')
        }
    },
    actions: {
        // loginAction: function (context, user) {
        //     context.commit('login', user);//提交mutation
        // },
        logoutAction: function(context){
            context.commit('logout');//提交mutation
        },
    }
}
