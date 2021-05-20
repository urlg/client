import Vue from 'vue'
import App from './App.vue'
import VueRouter from 'vue-router'
import main from "./components/main.vue"

/**
 *js
 */
import ShowMessage from "@/project/message/showMessage";
Vue.prototype.$showMessage = ShowMessage;
Vue.use(VueRouter)
Vue.config.productionTip = false;

/*
HttpUtil
 */
import HttpUtil from "@/DBcomm/HttpUtil.js";
Vue.prototype.$HttpUtil = HttpUtil;
Vue.config.productionTip = false;

/*
Http请求封装
 */
import Service from "@/DBcomm/Service";
Vue.prototype.$Service = Service;
Vue.config.productionTip = false;

// 2. 定义路由
const routes = [ //这里跟1.x有挺大区别，有接触的自己看清楚哦
  {
    path: '/',    //浏览器网路请求走通之后默认就会去找域名下的根目录，
    name: 'main', //所以我们就把这个组件作为默认首页
    component: main
  }
]

// 3. 创建 router 实例，然后传 `routes` 配置
// 你还可以传别的配置参数, 不过先这么简单着吧。
const router = new VueRouter({      //你就当const是var
  routes
//（缩写）相当于 routes: routes
})

new Vue({
  render: h => h(App),
  router
}).$mount('#app')
