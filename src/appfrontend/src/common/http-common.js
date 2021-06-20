import axios from 'axios';
let token=localStorage.getItem('anvil_token');
axios.defaults.headers.common = {'Authorization': `Bearer ${token}`}

export  const HTTP=axios.create({
    baseURL:`http://localhost:8096/api/`
});
