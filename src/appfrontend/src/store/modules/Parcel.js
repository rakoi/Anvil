
import {HTTP} from '../../common/http-common'
const state = {
    allparcels:[],
    undeliveredParcels:[],
    deliveredParcels:[],
    addParcel: {}
}

const getters = {
    getAllParcels: (state) => state.allparcels,
    getUndeliveredParcels: (state) => state.undeliveredParcels,
    getDeliveredParcels: (state) => state.deliveredParcels,

}


const actions = {
   
    async addParcel({commit},parcel){
        

        
        await HTTP.post('/parcel/addParcel',parcel)
        .then((resp)=>{
            console.log(resp.data)
            commit('setAddParcel',resp.data);
        });
    }

}


const mutations = {
    setAddParcel:(state,addParcel)=>(state.addParcel=addParcel),
}

export default{
    state, getters, actions, mutations
}