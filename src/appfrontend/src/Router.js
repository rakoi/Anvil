import VueRouter from "vue-router";
import Login from './components/pages/Login.vue'
import Dashboard from './components/pages/Dashboard.vue'
import NewParcel from './components/pages/NewParcel.vue'
import AllParcels from './components/pages/allParcels'
import EditParcel from './components/pages/EditParcel'
import ShowParcel from './components/pages/ShowParcel'
import AllTrips from  './components/pages/Trips/AllTrips'
import NewTrip from './components/pages/Trips/NewTrip'
import ShowTrip from './components/pages/Trips/ShowTrip'
import MyTrips from './components/pages/Trips/MyTrips'
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
        },
        {
            path:'/parcel/show/:id',
            name:'ShowParcel',
            component:ShowParcel
        },
        {
            path:'/parcel/edit/:id',
            name:'EditParcel',
            component:EditParcel
        },
        {
            path:'/parcel/all',
            name:'/allparcels',
            component:AllParcels
        },
        {
            path:'/trip/all',
            name:'/alltrips',
            component:AllTrips

        },
        {
            path:'/trip/new',
            name:'/newTrip',
            component:NewTrip

        },
        
        {
            path: '/trip/:id', 
            name:'showTrip',
            component:ShowTrip
        },
        
        {
            path: '/user/trips', 
            name:'mytrip',
            component:MyTrips
        }
    ]

});

export default router;