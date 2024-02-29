import Vue from 'vue'
import VueRouter from 'vue-router'
import ManageView from '../views/Manage'
import store from "@/store";

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'Manage',
    component: () => import(/* webpackChunkName: "about" */ '../views/Manage.vue'),
    redirect:"/Home",
    children:[
      {path:'home', name:'', component: () => import('../views/Home.vue')},
      {path:'dataprocessing', name:'数据处理', component: () => import('../views/Dataprocessing.vue')},
      {path:'person', name:'个人信息', component: () => import('../views/Person.vue')},
      {path:'register', name:'用户管理', component: () => import('../views/Register.vue')},
      {path:'file', name:'数据信息记录', component: () => import('../views/File.vue')},
      {path:'project', name:'任务管理', component: () => import('../views/Project.vue')},
    ]
  },
  {
    path: '/about',
    name: 'about',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/AboutView.vue')
  },
  {
    path: '/login',
    name: 'Login',
    component: () => import(/* webpackChunkName: "about" */ '../views/Login.vue')
  },
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

// 路由守卫
router.beforeEach((to, from, next) => {
  localStorage.setItem("currentPathName", to.name)  // 设置当前的路由名称，为了在Header组件中去使用
  store.commit("setPath")  // 触发store的数据更新
  next()  // 放行路由
})

export default router
