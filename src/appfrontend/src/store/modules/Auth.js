import axios from 'axios';

const state = {
    loggedIn: null,
    jwt:'',
}
const getters = {
    getLoggedInStatus: state => state.loggedIn
};
const actions = {
    sendToLoginPage() {
        if (state.loggedIn == false) {
            window.location.href = "/login"
        }
    },
    async logIn({commit}, credentials) {


        const response= await axios.post("http://localhost:8010/api/authenticate", {
            'username': credentials.username,
            'password': credentials.password,
        });
        var jwt = response.data.jwt;
      
        localStorage.setItem('anvil_token', jwt);
        commit('setLogedIn',true)
        if(jwt){
            window.location='/';
        }
     //   window.location='/';
        
     return response;
    }
};
const mutations = {
    setLogedIn:(state,status)=>(state.loggedIn=status)
}

export default {
    state, getters, actions, mutations
}