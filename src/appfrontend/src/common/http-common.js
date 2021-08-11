import axios from 'axios';

if(localStorage.getItem('anvil_token')!='expired'){

    let token=localStorage.getItem('anvil_token');
 
    axios.defaults.headers.common = {'Authorization': `Bearer ${token}`}
}





axios.defaults.headers.post['Content-Type'] = 'application/json';


export  const HTTP=axios.create({
    baseURL:`http://localhost:8096/api/`
});
