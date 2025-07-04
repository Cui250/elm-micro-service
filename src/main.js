import { createApp } from 'vue';
import App from './App.vue';
import router from './router';
import 'font-awesome/css/font-awesome.min.css';
import axios from 'axios';
import qs from 'qs';
import {
    getCurDate,
    setSessionStorage,
    getSessionStorage,
    removeSessionStorage,
    setLocalStorage,
    getLocalStorage,
    removeLocalStorage
} from './common.js';

// 创建 Vue 应用实例
const app = createApp(App);

// 设置 axios 的基础 URL
axios.defaults.baseURL = 'http://localhost:8080/elm/';

// 将 axios 和 qs 以及其他工具函数挂载到 app.config.globalProperties 上
app.config.globalProperties.$axios = axios;
app.config.globalProperties.$qs = qs;
app.config.globalProperties.$getCurDate = getCurDate;
app.config.globalProperties.$setSessionStorage = setSessionStorage;
app.config.globalProperties.$getSessionStorage = getSessionStorage;
app.config.globalProperties.$removeSessionStorage = removeSessionStorage;
app.config.globalProperties.$setLocalStorage = setLocalStorage;
app.config.globalProperties.$getLocalStorage = getLocalStorage;
app.config.globalProperties.$removeLocalStorage = removeLocalStorage;

// 使用路由
app.use(router);

// 全局前置守卫
router.beforeEach((to, from, next) => {
    let user = sessionStorage.getItem('user');
    // 除了登录、注册、首页、商家列表、商家信息之外，都需要判断是否登录
    const pathsThatDontRequireAuth = ['/index', '/businessList', '/businessInfo', '/login', '/register'];
    if (!pathsThatDontRequireAuth.includes(to.path) && !user) {
        // 使用 next() 函数来重定向，而不是直接调用 router.push
        next('/login');
    } else {
        // 如果不需要重定向，调用 next() 函数继续路由跳转
        next();
    }
});

// 挂载 Vue 应用
app.mount('#app');