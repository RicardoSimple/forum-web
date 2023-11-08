import { saveUserInfo } from '@/util/storeService'
import Vue from 'vue'
import VueRouter from 'vue-router'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'home',
    // component: HomeView
    component: () => import(/* webpackChunkName: "about" */ '../views/home/index.vue'),
    redirect: '/comment',
    children: [
      {
        path: '/comment',
        name: 'comment',
        component: () => import('../components/comment.vue')
      },
      {
        path: '/job',
        name: 'job',
        component: () => import('../components/job.vue')
      },
    ]
  },
  {
    path: '/currentUser',
    name: 'currentUser',
    component: () => import('../account/userhomepage1.vue'),
    redirect:'/currentUser/myartical',
    children:[
      {
        path:'/currentUser/myartical',
        name:'mycomment',
        component:()=> import('../account/userhomepage1_comment.vue'),
      },
      {
        path:'/currentUser/myjob',
        name:'job',
        component:()=>import('../account/userhomepage1_job.vue')
      },
      {
        path:'/currentUser/myCreatedjob',
        name:'createdjob',
        component:()=>import('../account/userhomepage1_createdjob.vue')
      }
    ]

  },
  {
    path: '/test/a',
    name: 'A',
    // component: HomeView
    component: () => import(/* webpackChunkName: "about" */ '../views/test/A.vue')
  },
  {
    path: '/test/b',
    name: 'B',
    // component: HomeView
    component: () => import(/* webpackChunkName: "about" */ '../views/test/B.vue')
  },
  {
    path: '/test/c',
    name: 'C',
    // component: HomeView
    component: () => import(/* webpackChunkName: "about" */ '../views/test/C.vue')
  },
  {
    path: '/test/d',
    name: 'D',
    // component: HomeView
    component: () => import(/* webpackChunkName: "about" */ '../views/test/D.vue')
  },
  {
    path: '/login',
    name: 'D',
    // component: HomeView
    component: () => import(/* webpackChunkName: "about" */ '../views/login/login.vue')
  },
  {
    path: '/register',
    name: 'D',
    // component: HomeView
    component: () => import(/* webpackChunkName: "about" */ '../views/login/register.vue')
  },
  {
    path: '/artical/:id',
    name: 'artical',
    // component: HomeView
    component: () => import('../views/artical/artical.vue'),
  },
  {
    path: '/user/:id',
    name: 'user',
    component: () => import('../account/userhomepage2.vue'),
    children:[
      {
        path:'/',
        redirect:'artical'
      },
      {
        path:'artical',
        name:'userartical',
        component:()=>import('../account/userhomepage2_comment.vue')
      },
      {
        path:'createdjob',
        name:'userjob',
        component:()=>import('../account/userhomepage2_createdjob.vue')
      }
    ]
    
  },
  {
    path: '/creat/artical',
    name: 'artical_new',
    // component: HomeView
    component: () => import(/* webpackChunkName: "about" */ '../views/artical/new.vue')
  },
  {
    path: '/jobdetail/:id',
    name: 'job',
    // component: HomeView
    component: () => import(/* webpackChunkName: "about" */ '../views/job/job.vue'),

  },
  {
    path: '/creat/job',
    name: 'job_new',
    // component: HomeView
    component: () => import(/* webpackChunkName: "about" */ '../views/job/new.vue')
  },


  //404页面，****如果继续添加路由，请在该路径上放***
  {
    path: '*',
    name: '404not',
    // component: HomeView
    component: () => import(/* webpackChunkName: "about" */ '../views/404not.vue')
  },

]

const router = new VueRouter({
  routes
})
// 添加全局路由守卫
router.beforeEach((to, from, next) => {
  // 检查用户是否已登录
  const userIsLoggedIn = checkUserLoggedIn(); // 实现此方法来检查用户登录状态

  if (to.name === 'login' && userIsLoggedIn) {
    // 如果用户已登录并尝试访问登录页，则自动重定向到首页
    next({ name: 'home' }); // 请替换 'home' 为您的首页路由名称
  } else {
    next(); // 继续导航
  }
});

// 检查用户是否已登录
function checkUserLoggedIn () {
  const cookies = document.cookie.split('; ');

  for (const cookie of cookies) {
    const [name, value] = cookie.split('=');
    if (name === 'attribute') { // 假设 'token' 是用于存储用户登录信息的 Cookie 名称
      // 用户已登录
      saveUserInfo(value)
      return true;
    }
  }

  // 用户未登录
  return false;
}

export default router
