import VueRouter from "vue-router";
import Login from './components/pages/Login.vue'
import Dashboard from './components/pages/Dashboard.vue'


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
        }
    ]

});

export default router;