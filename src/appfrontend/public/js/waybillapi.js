
//handle login
$('#loginform').submit(function (event) {
    event.preventDefault();

    var email=document.getElementById("email").value;
    var password=document.getElementById('password').value;

    axios.post('https://app.bpskenya.co.ke/api/account/login',{
        email:email,
        password:password,
    }).then((response)=>response).then((responsedata)=>
        if(responsedata.data.status)?:$('#')
    ).catch((error)=>console.log(error))

})