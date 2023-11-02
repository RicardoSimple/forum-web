import Vue from 'vue'
import App from './App.vue'
import router from './router'

/* element-ui */
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
Vue.use(ElementUI);

/* avue */
import Avue from '@smallwei/avue';
import '@smallwei/avue/lib/index.css';
Vue.use(Avue);

/* axios 拦截器注册 */
import axios from './router/axios';
import VueAxios from 'vue-axios';
Vue.use(VueAxios, axios);

/* 自定义请求工具 */
import crud from '@/util/crud'
Vue.prototype.crud = crud;

Vue.config.productionTip = false


new Vue({
  router,
  render: h => h(App)
}).$mount('#app')
