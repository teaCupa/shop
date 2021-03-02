import * as axios from "axios";
import {Message} from "element-ui";
import * as router from "vue-router";

let base = ''

axios.interceptors.response.use(success => {
    //状态码为200可能为错误请求,如密码错误
    if (success.status && success.status === 200 && success.data.status > 400) {
        Message.error({message: success.data.msg})
        return;
    }
    return success.data;
}, error => {
    if (error.response.status >= 500 || error.response.status === 404) {
        Message.error({message: '服务器被吃了( ╯□╰ )'})
    } else if (error.response.status === 401) {
        Message.error({message: '尚未登录，请登录'})
        setTimeout(()=>{
            router.replace('/login')
        },1500)
    }else if (error.response.status === 403) {
        Message.error({message: '权限不足'})
    } else {
        if (error.response.data.msg) {
            Message.error({message: error.response.data.msg})
        } else {
            Message.error({message: '未知错误!'})
        }
    }
})

export const postKeyValueRequest = (url, params) => {
    return axios({
        method: 'post',
        url: `${base}${url}`,
        data: params,
        transformRequest: [function (data) {
            let ret = '';
            for (let i in data) {
                ret += encodeURIComponent(i) + '=' + encodeURIComponent(data[i]) + '&'
            }
            return ret.substring(0, ret.length - 1);
        }],
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded'
        }
    });
}
export const getRequest = (url, params) => {
    return axios({
        method: 'get',
        url: `${base}${url}`,
        data: params
    })
}
export const putRequest = (url, params) => {
    return axios({
        method: 'put',
        url: `${base}${url}`,
        data: params
    })
}
export const postRequest = (url, params) => {
    return axios({
        method: 'post',
        url: `${base}${url}`,
        data: params
    })
}
export const deleteRequest = (url, params) => {
    return axios({
        method: 'delete',
        url: `${base}${url}`,
        data: params
    })
}


