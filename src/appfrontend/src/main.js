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
import Vuetify from 'vuetify';
import DataTable from "@andresouzaabreu/vue-data-table";
import PrimeVue from 'primevue/config';
import "bootstrap/dist/css/bootstrap.min.css";
import "@andresouzaabreu/vue-data-table/dist/DataTable.css";

import "primevue/resources/themes/saga-blue/theme.css"       //theme
import "primevue/resources/primevue.min.css"                 //core css
import "primeicons/primeicons.css"                           //icons


Vue.component("data-table", DataTable);

Vue.use(PrimeVue);

const vuetifyOptions = { }


// var $ = require( 'jquery' );

//  require( 'datatables.net' )( window, $ );
// require( 'datatables.net-bs' )( window, $ );


Vue.use(Vuetify);


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
  vuetify: new Vuetify(vuetifyOptions),
  render: h => h(App),
}).$mount('#app')
