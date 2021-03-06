import Vue from 'vue'
import App from './App.vue'
import VueRouter from 'vue-router'
import router from './Router'
import store from './store'
import cors from 'cors'
import VueAutosuggest from "vue-autosuggest";
import { BootstrapVue } from 'bootstrap-vue'
import Vuelidate from 'vuelidate'
import Vuetify from 'vuetify';
import DataTable from "@andresouzaabreu/vue-data-table";
import PrimeVue from 'primevue/config';
import "bootstrap/dist/css/bootstrap.min.css";
import "@andresouzaabreu/vue-data-table/dist/DataTable.css";

import "primevue/resources/themes/saga-blue/theme.css"       //theme
import "primevue/resources/primevue.min.css"                 //core css
import "primeicons/primeicons.css"    
import VueToast from 'vue-toast-notification';
import 'vue-toast-notification/dist/theme-default.css';   
import VModal from "vue-js-modal";

import VueToastify from "vue-toastify";
import VueHtmlToPaper from 'vue-html-to-paper';


const options = {
  name: '_blank',
  specs: [
    'fullscreen=yes',
    'titlebar=yes',
    'scrollbars=yes'
  ],
  styles: [
    'https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css',
    'https://unpkg.com/kidlat-css/css/kidlat.css',
    'https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css'
  ]
}

Vue.use(VueHtmlToPaper,options);

Vue.use(VueToast);


Vue.component("data-table", DataTable);
Vue.use(VModal);

import ToastService from 'primevue/toastservice';
Vue.use(ToastService);

Vue.use(PrimeVue);

import ConfirmationService from 'primevue/confirmationservice';
Vue.use(ConfirmationService);


const vuetifyOptions = { }


// var $ = require( 'jquery' );

//  require( 'datatables.net' )( window, $ );
// require( 'datatables.net-bs' )( window, $ );


Vue.use(Vuetify);




Vue.use(Vuelidate)

Vue.use(BootstrapVue)

Vue.config.productionTip = false



Vue.use(VueToastify,{
  position:"top-right"
});


Vue.use(VueAutosuggest);
Vue.use(VueRouter);
Vue.use(cors)
new Vue({

  store,
  router,
  vuetify: new Vuetify(vuetifyOptions),
  render: h => h(App),
}).$mount('#app')
