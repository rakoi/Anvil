import axios from 'axios';

const state = {
    loggedIn:null,
    jwt:null,
    user:{}
}
const getters = {
    
    getloggedIn:(state)=>state.loggedIn,
    getLoggedInUser:(state)=>state.user

};


const actions = {
   async logIn({commit}, credentials) {

        
        const response= await axios.post("http://localhost:8096/api/authenticate", {
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

    async getUser({commit}){
          
        
        // const response=await axios.get('http://127.0.0.1:8096/api/getUserDetails');
        // console.log(response.data)
        //console.log(HTTP);
       
    

            let token=localStorage.getItem('anvil_token');
            
            const response=await axios.get("http://127.0.0.1:8096/api/getUserDetails",{
                headers:{
                    'Content-Type': 'application/json',
                    "Authorization":`Bearer ${token}`,
              
                   
                
                }
            });
          
            var user=response.data.user;
            // console.log('user is');
            // console.log(user);
         
          
           commit('setUser',user);
       
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
    setUser:(state,user)=>{
      
        state.user=user;
       
    }
   
}

export default {
    state, getters, actions, mutations
}
