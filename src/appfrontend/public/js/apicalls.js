var url = "http://localhost:8080/api";

var parcels = [];
var mylabels=[];

//var vehicleslist=[]


fuelChart();

if (parcels.length<=0){

    $('#loadparcelsbtn').addClass('disabled');
    $('#loadparcelsbtn').attr('disabled', true);
    $('#recieveparcelBtn').addClass('disabled');
    $('#recieveparcelBtn').attr('disabled', true);
}


function fetchSenderById() {

    var id = document.getElementById("senderid").value;
    var firstname = document.getElementById("sfirstName");
    var lastname = document.getElementById("slastName");
    var email = document.getElementById("semail");
    var address = document.getElementById("saddress");
    var phone = document.getElementById("sPhoneNumber");
    var business = document.getElementById("sbusiness");
    var town = document.getElementById("stown");
    fetch(url + "/senders/id/" + id).then((response) => response.json()).then(function (data) {
        firstname.value = data['fname'];
        lastname.value = data['lname'];
        email.value = data['email'];
        phone.value = data['phone'];
        address.value = data['phone'];
        town.value = data['town'];
        business.value = data['businessname'];

    }).catch(function (reason) {
        if(id){id.value=""}
    })

    validatePhoneNumbers();
}


function fetchConsigneeById() {

    var id = document.getElementById("recieverid").value;
    var firstname = document.getElementById("rfirstName");
    var lastname = document.getElementById("rlastName");
    var email = document.getElementById("remail");
    var address = document.getElementById("raddress");
    var phone = document.getElementById("rPhoneNumber");
    var business = document.getElementById("rbusiness");
    var town = document.getElementById("rtown");
    fetch(url + "/recievers/id/" + id).then((response) => response.json()).then(function (data) {
        firstname.value = data['fname'];
        lastname.value = data['lname'];
        email.value = data['email'];
        phone.value = data['phone'];
        address.value = data['phone'];
        town.value = data['town'];
        business.value = data['businessname'];
    }).catch(function (reason) {
        firstname.value = "";
        lastname.value = "";
        email.value = "";
        phone.value = "";
        address.value = "";
        town.value = "";
        business.value = "";
    })
    validatePhoneNumbers()
}
;
function fetchSenderByPhoneNumber() {


        var phone = document.getElementById("sPhoneNumber").value;

        var senderId=document.getElementById('senderid');
        var firstname = document.getElementById("sfirstName");
        var lastname = document.getElementById("slastName");
        var email = document.getElementById("semail");
        var address = document.getElementById("saddress");
        var business = document.getElementById("sbusiness");
        var town = document.getElementById("stown");
        fetch(url + "/senders/" + phone).then((response) => response.json()).then(function (data) {
            firstname.value = data['fname'];
            if(senderId){senderId.value=data['id']}
            if(lastname){lastname.value=data['lname']}
            if(email){email.value = data['email'];}
            if(address){address.value = data['phone'];}
            if(town){town.value = data['town'];}
            if(business){business.value = data['businessname'];}

        }).catch(function (reason) {
            if(senderId){senderId.value=0}
        })
        validatePhoneNumbers();



}

function fetchConsigneeByPhoneNumber() {


 //   console.log("FETCHING RECIEVER");
    var id=document.getElementById("receverid");

    var phone = document.getElementById("rPhoneNumber").value;
    var firstname = document.getElementById("rfirstName");
    var lastname = document.getElementById("rlastName");
    var email = document.getElementById("remail");
    var address = document.getElementById("raddress");
    var business = document.getElementById("rbusiness");
    var town = document.getElementById("rtown");
    fetch(url + "/recievers/" + phone).then((response) => response.json()).then(function (data) {
      //  console.log(data);
        if(id){id.value=data['id']}
        if(firstname){firstname.value=data['fname'];}
        if(lastname){lastname.value=data['lname']}
        if(email){email.value = data['email'];}
        if(address){address.value = data['phone'];}
        if(town){town.value = data['town'];}
        if(business){business.value = data['businessname'];}


    }).catch(function (reason) {

        if(id){id.value=0}
    })

    validatePhoneNumbers();



}

//scan parcel
function scanParcel() {


    var parcelId = document.getElementById("parcelId").value;

    document.getElementById("overlay").style.display = "block";




    fetch(url + "/parcel/" + parcelId).then((response) => response.json()).then(
        function (data) {



            document.getElementById("parcelId").value = "";
            $('#parcelId').focus();

            $('#recieveparcelBtn').removeClass('disabled');
            $('#recieveparcelBtn').attr('disabled', false);
            $('#loadparcelsbtn').removeClass('disabled');
            $('#loadparcelsbtn').attr('disabled', false);
            $('#response').text('')

            if (!Parcelscontains(data)) {
                parcels.push(data)
                $('#loadParcelsTable').append(`<tr>
                <td>${data['id']}</td>
                <td>${data['sender']['town']}</td>
                <td>${data['reciever']['town']}</td>
                 <td>${data['reciever']['businessname']}</td>
                <td>${data['quantity']}</td>
                  <td>${data['weight']}</td>
                   <td>${data['description']}</td>
                     <td><a onclick="
                     $(this).parent().parent().remove();
                     removeItem(${data['id']})"  id="deleteloadedparcel" class="btn btn-primary" style="color: white;">Remove</a></td>
                </tr>`);

            }

            document.getElementById("overlay").style.display = "none";
//Mw==

        }
    ).catch(function (reason) {
        document.getElementById("parcelId").value = "";

        document.getElementById("overlay").style.display = "none";

        //console.log(reason);
    });


}


function removeItem(id) {

    document.getElementById("parcelId").value = "";
    parcels.splice(parcels.indexOf(getParcelById(id)), 1);
    $('#parcelId').focus();

}

function getParcelById(id) {

    for (var i = 0; i < parcels.length; i++) {
        if (parcels[i].id === id) {
            return parcels[i];
        }

    }

}
//check if item is in list
function Parcelscontains(Obj) {

    for (var i = 0; i < parcels.length; i++) {
        if (parcels[i].id === Obj.id) {
            return true;
        }

    }
    return false
}

function loadParcels() {


    var counter=0;
    var tripId=document.getElementById('tripid').value;



    document.getElementById("overlay").style.display = "block";


    parcels.forEach(function (value,key) {


        fetch(url+"/assignParcel/"+tripId+"/"+value['id']).then((response)=>response.json()).then(
            function (data) {
                counter++


                if (counter==parcels.length){

                 //ss   mymodal.modal('toggle')
                    $('#loadparcelsbtn').addClass('disabled');
                    $('#loadparcelsbtn').attr('disabled', true);
                    $('#response').text('Parcels have been loaded')
                }
            }
        ).catch(function (reason) {
            console.log(reason);
        });




    })
    document.getElementById("overlay").style.display = "none";

}


function recieveParcels() {
    var counter=0;

    document.getElementById("overlay").style.display = "block";


    parcels.forEach(function (value,key) {


        fetch(url+"/recieveParcel/"+value['encodedId']).then((response)=>response.json()).then(
            function (data) {
                console.log(data)
                counter++

                if (counter==parcels.length){

                    //ss   mymodal.modal('toggle')
                    $('#recieveparcelBtn').addClass('disabled');
                    $('#recieveparcelBtn').attr('disabled', true);
                    $('#response').text('Parcels have been Recieved')
                }
            }
        ).catch(function (reason) {
            console.log("Recieve error"+reason);



        });

        document.getElementById("overlay").style.display = "none";



    })
}

function fetchVehicles() {
    fetch(url + "/vehicle/getAll").then((response) => response.json()).then(function (data) {
       //vehicleslist=data
        fillVehicleList(data)
    }).catch(function (reason) {
       //s alert(reason)

    })
}
function  fillVehicleList(vehicleslist) {
    vehicleslist.forEach(function (vehicle) {
        //console.log(vehicle.id)
        var div=document.createElement('div');
        div.className='vehiclesList col-md-4'
        div.innerHTML= `  <div >
                 <div class="card border-left-primary shadow h-100 py-2">
                <div class="card-body">
                    <div class="row no-gutters align-items-center">
                        <div class="col mr-2">
                            <div class="text-xs font-weight-bold text-primary text-uppercase mb-1"></div>
                            <div class="h5 mb-0 font-weight-bold text-gray-800">
                                <a href="vehicle/${vehicle.id}" class="card-link">${vehicle.registration}</a><br>
                                <small>${vehicle.model}</small><br>
                            </div>
                        </div>
                        <div class="col-auto">
                            <i class="fas fa-truck fa-2x text-gray-300"></i><br>
                        </div>
                    </div>
                    <a href="selectvehicle/${vehicle.id}" class="float-right"><small class="fa fa-hand-point-up"></small>Select</a><br>
       
                </div>
            </div></div>`
        document.getElementById('vehiclesList').appendChild(div);
    })

}
function getVehicleByRegistration() {
    var registation=document.getElementById('registration').value;

    if(!registation){
        $('.vehiclesList').remove('div')

        fetchVehicles()
    }else if(registation.length>0) {

        $('.vehiclesList').remove('div')
        fetch(url + "/vehicle/" + registation).then((response) => response.json()).then(function (data) {

            //vehicleslist=[]
            //  vehicleslist=data
            fillVehicleList(data)
            //console.log(vehicleslist)

        }).catch(function (reason) {
            // alert(reason)

        })
    }
}

function fuelChart() {

    var xdata=[]
   fetch(url + "/fuelReport").then((response) => response.json()).then(function (data) {
        displaychart(data.values);
        xdata=data.months;
    });




}

function displaychart(data) {
    var ctx = document.getElementById('fuelChart');
    var ctx = new Chart(ctx, {
        type: 'line',
        data: {
            labels: ["Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"],

            datasets: [{
                label: "Fuel",
                lineTension: 0.3,
                backgroundColor: "rgba(78, 115, 223, 0.05)",
                borderColor: "rgba(78, 115, 223, 1)",
                pointRadius: 3,
                pointBackgroundColor: "rgba(78, 115, 223, 1)",
                pointBorderColor: "rgba(78, 115, 223, 1)",
                pointHoverRadius: 3,
                pointHoverBackgroundColor: "rgba(78, 115, 223, 1)",
                pointHoverBorderColor: "rgba(78, 115, 223, 1)",
                pointHitRadius: 10,
                pointBorderWidth: 2,
                data: data,
            }],
        },
        options:{
            animation:{

            }
        }

    });

}
function generateLabels(){



    var number=document.getElementById("no_of_labels").value;


    if (number>0){


        for (var i=0;i<number;i++){
            $("#message").text("Please Wait");


            fetch(url + "/addLabel").then((response) => response.json()).then(function (data) {
                $('#labels').append(`
                    <li class="list-group-item">
                           <img src="/resources/labels/${data['id']}.PNG"  width="100" height="50">
                    </li>

                `);


            }).catch(function (reason) {

                console.log(reason);

            })

        }

    }
    $("#message").text("");
}
