import Vue from 'vue'
import App from './App.vue'
import VueRouter from 'vue-router'
import router from './Router'
import store from './store'
import cors from 'cors'
import VueAutosuggest from "vue-autosuggest";
import { BootstrapVue } from 'bootstrap-vue'
import Vuelidate from 'vuelidate'
import VueToast from 'vue-toast-notification';

import 'vue-toast-notification/dist/theme-sugar.css';

// import { VuejsDatatableFactory,TColumnsDefinition} from 'vuejs-datatable';

import Vuetable from 'vuetable-2'


 
Vue.use( Vuetable );




Vue.use(Vuelidate)
Vue.use(VueToast);
Vue.use(BootstrapVue)
Vue.use(VueToast, {
  // One of the options
  position: 'top'
})
Vue.config.productionTip = false

Vue.use(VueAutosuggest);
Vue.use(VueRouter);
Vue.use(cors)
new Vue({
  store,
  router,
  render: h => h(App),
}).$mount('#app')
