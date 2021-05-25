import vue from 'vue'
import Vuex from  'vuex'
import Auth from './modules/Auth'


vue.use(Vuex)

export default new Vuex.Store({
    modules:{
        Auth
    }
})