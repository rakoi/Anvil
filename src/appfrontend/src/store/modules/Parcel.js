
import { HTTP } from '../../common/http-common'
import Vue from 'vue'
const state = {
    incomingParcels: {},
    undeliveredParcels: {},
    sentParcels: {},
    addParcel: {}
}

const getters = {
    getIncomingParcels: (state) => state.incomingParcels,
    getUndeliveredParcels: (state) => state.undeliveredParcels,
    getDeliveredParcels: (state) => state.deliveredParcels,
    getSentParcels: (state) => state.sentParcels,
    getAddedParcel:(state)=>state.addParcel

}


const actions = {

     fetchIncomingParcel({ commit }) {
         HTTP.get('/parcel/allincoming').then((resp) => {
          
              commit('setIncomingParcel', resp.data)
        })
    },

    


    async fetchSentParcels({ commit }) {
       
        await HTTP.get('/parcel/findAllByOrigin').then((resp) => {
          
            commit('setSentParcel', resp.data)
        })
    },

    async fetchUndeliveredParcels({ commit }) {
        await HTTP.get('/parcel/findAllUncollected').then((resp) => {
                 commit('setUncollected', resp.data)
        })
    },



    async addParcel({ commit }, parcel) {



        await HTTP.post('/parcel/addParcel', parcel)
            .then((resp) => {
             

                Vue.$toast.open({
                    message: `Parcel ${resp.data.id} has been saved`,
                    type: 'success',
                    // all of other options may go here
                });
                commit('setAddParcel', resp.data);
                
            }).catch((e) => {
                console.log(e);
                Vue.$toast.open({
                    message: "Error saving parcel ",
                    type: 'error',
                    // all of other options may go here
                });
            });
    }

}


const mutations = {
    setAddParcel: (state, addParcel) => (state.addParcel = addParcel),
    setIncomingParcel: (state, incomingParcels) =>{
        state.incomingParcels = incomingParcels;
       
    },
    setSentParcel:(state,sent)=>(state.sentParcels=sent),
    setUncollected:(state,undeliveredParcels)=>(state.undeliveredParcels=undeliveredParcels)
}

export default {
    state, getters, actions, mutations
}