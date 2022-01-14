<template>
<div id="newparcel">
    <appLayout>

        <div class="container-fluid">

            <!-- Page Heading -->
            <div class="row">
                <div class="col-md-4">
                    <h1 class="h3 mb-2 text-gray-800">Parcel Details</h1>
                </div>
                <div class="col-md-4 mb-2">
                    <button class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm" onclick="printLabel()"><i class="fas fa-print fa-sm text-white-50"></i> Print Label</button>
                </div>
                <div class="col-md-4">
                    <button class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm" onclick="printReciept()"><i class="fas fa-print fa-sm text-white-50"></i> Print Reciept</button>
                </div>
            </div>

            <!-- Content Row -->
            <div class="row">
                <!-- Donut Chart -->
                <div class="col-xl-4 col-lg-5">
                    <div class="card shadow mb-4">

                        <!-- Card Header - Dropdown -->
                        <div class="card-header py-3">
                            <h6 class="m-0 font-weight-bold text-primary">Parcel</h6>

                        </div>
                        <!-- Card Body -->
                        <div class="card-body">
                            <div class="card-img-top">
                                <div id="label">
                                    <small>Anvil</small><br>
                                    <div class="row">
                                        <div class="col col-12 col-md-12">
                                            <img :src="labelUrl"  alt="Qrcode" width="250" height="250" class="img-thumbnail">
                                        </div>

                      

                                    </div>

                                </div>

                            </div>
                            <br>
                            <div class="card-footer">

                                <span>Quantity:{{parcel.quantity}}</span><br>
                                <span>Weight:{{parcel.kilograms}}Kgs</span><br>
                                <span>Price:Ksh {{parcel.price}}</span><br>
                                <span>Payment :{{parcel.amount_paid}}</span><br>
                                <hr>
                                <a @click="editParcel" class="btn btn-info btn-block">Edit </a> <br>
         
                                <div class="d-md-none" style="padding-top: 20px">
                                    <button id="printbtn" class="btn btn-sm btn-primary shadow-sm" onclick="printLabel()"><i class="fas fa-print fa-sm text-white-50"></i> Print Label</button><br>
                                    <button id="printbtn" class="btn btn-sm btn-primary shadow-sm" onclick="printReciept()"><i class="fas fa-print fa-sm text-white-50"></i> Print Reciept</button>

                                </div>

                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-xl-8 col-lg-7">

                    <!-- Area Chart -->
                    <div class="card shadow mb-4">
                        <div class="card-header py-3">
                            <h6 class="m-0 font-weight-bold text-primary">From: </h6>

                        </div>
                        <div class="card-body">
                            <table class="table table-bordered table-striped">
                            <tr>
                                    <td><b>Name : </b>{{parcel.sender.first_name}} {{parcel.sender.last_name}}</td>
                                </tr>
                                <tr>
                                    <td><b>Phone : </b>{{parcel.sender.phone}}</td>
                                </tr>
                                <tr>
                                    <td><b>Email Address : </b>{{parcel.sender.email}}</td>
                                </tr>
                            </table>

                        </div>
                    </div>

                    <!-- Bar Chart -->
                    <div class="card shadow mb-4">
                        <div class="card-header py-3">
                            <h6 class="m-0 font-weight-bold text-primary">Deliver to:{{parcel.reciever.first_name}} {{parcel.reciever.last_name}}</h6>
                        </div>
                        <div class="card-body">
                            <table class="table table-striped table-bordered">
                                <tr>
                                    <td><b>Phone : </b>{{parcel.reciever.phone}}</td>
                                </tr>
                               
                                <tr>
                                    <td><b>Town : </b>{{parcel.destination.name}}</td>
                                </tr>
                                  <tr>
                                    <td><b>Email Address : </b>{{parcel.reciever.email}}</td>
                                </tr>
                              
                            </table>

                        </div>

                    </div>

                    <div class="reciept card shadow mb-4 " id="reciept">
                        <div class="card-header py-3">
                            <h6 class="m-0 font-weight-bold text-primary">Reciept</h6>
                        </div>
                        <div class="card-body">
                            <h6 class="pull-right">Date:{{parcel.timeStamp}}</h6>
                            <table class="table table-striped table-bordered">
                                <tr>
                                    <td>From : {{parcel.sender.first_name}} {{parcel.sender.last_name}} </td>
                                    <td>To : {{parcel.reciever.first_name}} {{parcel.reciever.last_name}}</td>
                                </tr>
                                <tr>
                                   
                                    <td><b>Contact : </b>{{parcel.reciever.phone}}</td>
                                </tr>
                               
                              
                                <tr>
                                    <td>Price Ksh:{{parcel.price}}</td>
                                </tr>
                            </table>

                        </div>
                    </div>
                </div>

            </div>

        </div>
        <!-- /.container-fluid -->

        <!-- /.container-fluid -->
    </appLayout>
</div>
</template>

<script>
import appLayout from "../layout/appLayout";
import {
    HTTP
} from '../../common/http-common'

export default {
    components: {
        appLayout,

    },
    created() {
        let url = '/parcel/getParcel/' + this.$route.params.id;
        this.labelUrl=process.env.VUE_APP_SERVICE_URB+'label/'+this.$route.params.id+'.png';

        HTTP.get('stations/all').then((resp) => {
            this.stations = resp.data;
        })

        HTTP.get(url).then((resp) => {
           
            this.parcel = resp.data;
            this.reciever = resp.data.reciever;
            this.sender = resp.data.sender;
             console.log(resp.data)

        });

    },
    data() {
        return {
            sender: {},
            errors: [],
            reciever: {},
            parcel: {},
            payment_method: "",
            stations: [],
            labelUrl:'',
        };
    },
    methods: {
       editParcel:function(){
            let parcelId= this.$route.params.id;
                
             this.$router.push({
                 name: 'EditParcel',
                 params: {
                     id: parcelId
                 }
             });
       }
       
        
    },
};
</script>
