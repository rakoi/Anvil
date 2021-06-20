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
import {HTTP} from '../../common/http-common'

export default {

    data(){
        return{
            number:'+2547',
            phoneNumbers:null,
        }
    },
    methods:{
        searchByNumber(){
        


        //let token=localStorage.getItem('anvil_token');
          
            
            HTTP.get(
                `client/searchByPhone/${this.number}`
                )
            .then((resp)=>{
                console.log(resp.data);
                this.phoneNumbers=resp.data;

            }).catch((error)=>{
                console.log(error);
            });
        }
    }
    
}
</script>