<template>
   <div id="autocomplete">
          <input
                    type="text"
                    class="form-control"
                    id="sPhoneNumber"
                    name="sender.phone"
                    required="true"
                    v-model="number"
                    v-on:keyup="searchByNumber()"
                  />
   </div>
</template>

<script>
import axios from 'axios';
export default {

    data(){
        return{
            number:'+2547'
        }
    },
    methods:{
        searchByNumber(){

            let token=localStorage.getItem('anvil_token');
            axios.get(`http://127.0.0.1:8096/api/client/searchByPhone/${this.number}`,{
                 headers:{
                    'Content-Type': 'application/json',
                    "Authorization":`Bearer ${token}`,
              
                   
                
                }
            })
            .then((resp)=>{
                console.log(resp);
            }).catch((error)=>{
                console.log(error);
            });
        }
    }
    
}
</script>