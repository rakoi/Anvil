import VueRouter from "vue-router";
import Login from './components/pages/Login.vue'
import Dashboard from './components/pages/Dashboard.vue'
import NewParcel from './components/pages/NewParcel.vue'

const router=new VueRouter({

    mode:'history',
    routes:[
        {
            path:'/login',
            name:'/Login',
            component:Login
        },
        {
            path:'/',
            name:'/Dashboard',
            component:Dashboard
        },
        {
            path:'/parcel/new',
            name:'/newparcel',
            component:NewParcel
        }
    ]

});

export default router;