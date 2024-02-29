import Vue from 'vue'
import Vuex from 'vuex'
//解决面包屑传值问题
Vue.use(Vuex)

const store = new Vuex.Store({
    state: {
        currentPathName: ''
    },
    mutations: {
        setPath (state) {
            state.currentPathName = localStorage.getItem("currentPathName")
        }
    }
})

export default store