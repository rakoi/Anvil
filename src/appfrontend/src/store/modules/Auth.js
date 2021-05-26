import axios from 'axios';

const state = {
    loggedIn:null,
    jwt:null,
}
const getters = {
    
    getloggedIn:(state)=>state.loggedIn


};


const actions = {
   async logIn({commit}, credentials) {

        
        const response= await axios.post("http://localhost:8010/api/authenticate", {
            'username': credentials.username,
            'password': credentials.password,
        });
        var jwt = response.data.jwt;
        
      
        localStorage.setItem('anvil_token', jwt);
      
     

        //update on validate token
        commit('setLoggedIn',true);

        commit('setJwt',jwt);

        return response;
    
    },

    sendToLoginPage(){

        alert(state.loggedIn);


    },
    logoutUser({commit}){

      
        commit('setLoggedIn',false);
        commit('setJwt',null);

    }

    
};
const mutations = {

    setLoggedIn:(state,loggedIn)=>(state.loggedIn=loggedIn),
  
    setJwt:(state,token)=>{
        state.jwt=token
        
    },
   
}

export default {
    state, getters, actions, mutations
}
