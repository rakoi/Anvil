import Vue from 'vue'
import App from './App.vue'
import VueRouter from 'vue-router'
import router from './Router'
import store from './store'
import cors from 'cors'
import VueAutosuggest from "vue-autosuggest";


Vue.config.productionTip = false

Vue.use(VueAutosuggest);
Vue.use(VueRouter);
Vue.use(cors)
new Vue({
  store,
  router,
  render: h => h(App),
}).$mount('#app')
