/**
 * 全站http配置
 *
 * axios参数说明
 * isSerialize是否开启form表单提交
 * isToken是否需要token
 */
import axios from 'axios'
import router from '@/router'
import NProgress from 'nprogress'  // progress bar
import {Message} from 'element-ui'
axios.defaults.timeout = 10000;

//返回其他状态吗
axios.defaults.validateStatus = function (status) {
    return status >= 200 && status <= 500; // 默认的
};


//跨域请求，允许保存cookie
axios.defaults.withCredentials = true;
// axios.defaults.baseURL = '/api'
// NProgress Configuration
NProgress.configure({
    showSpinner: false
});


//HTTP request拦截
axios.interceptors.request.use(config => {
    // console.debug(" 发起请求:", config.url)
    // start progress bar
    NProgress.start();
    // 请求中添加token
    let token = sessionStorage.getItem("TOKEN");
    config.headers["TOKEN"] = token;
    return config;
}, error => {
    return Promise.reject(error)
});



//HTTP response拦截
axios.interceptors.response.use(res => {
    console.debug(res.config.url, "  =》 res:", res)
    NProgress.done();
    const status = Number(res.status) || 200;
    const message = res.data.message || '后台服务走丢了,请稍后重试...';

    // 如果服务器响应非200否者默认统一处理
    if (status !== 200) {
        Message({ message: message,  type: 'error'});
        return Promise.reject(new Error(message))
    }

    // 判断是否是文件，是文件就直接返回
    if ((res.data != null && res.data instanceof Blob)
        || (res.headers["content-type"] != null && res.headers["content-type"].indexOf('application/octet-stream') != -1)) {
        return res;
    }

    // 需要登录的接口 判断是否登录过期
    if (res.data.code === 10000) {
        Message({  message: res.data.msg,  type: 'error'  });
        //router.push({path: "/login"});
        // 跳登录页
        return Promise.reject(new Error(res.data.msg))
    }

    // 判断状态码是否不等于200
    if (res.data.code !== 200) {
        Message({  message: res.data.msg,  type: 'error' })
        return Promise.reject(new Error(res.data.msg))
    }


    // 请求成功
    if (res.config != null && res.config.method !== "get" && res.config.method !== "GET") {
        // 成功提示
        Message({  message: res.data.msg,  type: 'success' })
    }

    // 自动刷新 token 来进行续期
    if (res.headers.token !== undefined && res.headers.token !== null) {
        let newToken = res.headers.token;
        sessionStorage.setItem("TOKEN",newToken)
        // setToken(newToken);
        //setStore({name: 'token', content: newToken})
    }


    return res;
}, error => {
    NProgress.done();
    return Promise.reject(new Error(error));
});

export default axios;