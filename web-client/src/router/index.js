import Vue from 'vue'
import VueRouter from 'vue-router'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'home',
    // component: HomeView
    component: () => import(/* webpackChunkName: "about" */ '../views/home/index.vue'),
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
    path:'/home/userhomepage1',
    name:'userhomepage1',
    component:()=>import(/*webpackChunkName:"about"*/'../account/userhomepage1.vue')
  },
  {
    path:'/home/userhomepage2',
    name:'userhomepage2',
    component:()=>import(/*webpackChunkName:"about"*/'../account/userhomepage2.vue')
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
]

const router = new VueRouter({
  routes
})

export default router