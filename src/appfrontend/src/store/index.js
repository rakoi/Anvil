import vue from 'vue'
import Vuex from  'vuex'
import Auth from './modules/Auth'
import Parcel from './modules/Parcel'
import createPersistedState from "vuex-persistedstate";

vue.use(Vuex)

export default new Vuex.Store({
    plugins: [createPersistedState()],
    
    modules:{
        Auth,
        Parcel
    }
})