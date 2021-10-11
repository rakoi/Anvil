import axios from 'axios';

if(localStorage.getItem('anvil_token')!='expired'&&localStorage.getItem('anvil_token')){
    let token=localStorage.getItem('anvil_token');
    console.log(token);
    if(token.length>1){
        axios.defaults.headers.common = {'Authorization': `Bearer ${token}`}
    }
    
  
}





axios.defaults.headers.post['Content-Type'] = 'application/json';


export  const HTTP=axios.create({
    baseURL:`http://localhost:8096/api/`
});
