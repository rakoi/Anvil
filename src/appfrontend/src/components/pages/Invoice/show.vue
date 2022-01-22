<template>
<appLayout>
    <div id="allinvoices">
        <div class="invoicediv" id="invoicediv">

            <div style="margin-left:1%;">
                <h1>Invoice</h1>
                <hr>

                <button v-if="this.invoice.status==true" class="btn btn-success btn-warning btn-sm" disabled style="width:5% ; height:5% "> <span>Paid</span></button>

                <button v-else class="btn  btn-danger btn-sm" disabled style="width:8% ; height:5% "> <span>Not Paid</span></button>

            </div>

            <div class="row " style="margin-top:2%;margin-left:1%;">
                <div class="col col-md-3">
                    <label><b>Invoice Number</b></label>
                    <div class="input-group mb-3">
                        INV{{invoice.id}}
                    </div>

                </div>

                <div class="col col-md-3">
                    <label><b>Date</b></label>
                    <div class="input-group mb-3">

                        {{invoice.date}}
                    </div>
                </div>
            </div>

            <hr class="sidebar-divider d-none d-md-block" style="margin-left:10%; margin-right:10%">

            <div class="row" style="margin-top:2%; margin-left:1%; ">
                <div class="col col-md-3">
                    <div class="alert alert-info">Client</div> <br>
                    <b> Name :</b>{{invoice.clientNames}}<br>
                    <b>Phone :</b>{{invoice.client.phone}}
                </div>
                <div class="col col-md-6">
                </div>

            </div>

            <hr style="margin-left:8%;margin-right:8%">
            <div class="row " style="margin-top:2% ; margin-left:2%">
                <h4>Items</h4>
                <table class="table">
                    <thead>
                        <tr>
                            <th scope="col">#</th>

                            <th scope="col">Kilograms</th>
                            <th scope="col">Quantity</th>
                              <th scope="col">Price</th>

                        </tr>
                    </thead>
                    <tbody>
                        <tr v-for="parcel in invoice.parcels" :key="parcel.id">
                            <th scope="row">{{parcel.id}}</th>
                            <th scope="row">{{parcel.kilograms}} Kg</th>
                            <th scope="row">{{parcel.quantity}} Item(s) </th>
                               <th scope="row">{{parcel.price}} </th>

                        </tr>

                    </tbody>
                </table>
            </div>

            <div>

            </div>

            <div style="margin-left:80%; padding-top:3%">
                Total: {{invoice.total}}/=
            </div>
        </div>

        <div class="row">
            <div class="col col-md-2">
                <button class="btn btn-success btn-default btn-dark" @click="printInvoice"> <i class="fa fa-print"></i> <span>Print</span></button>
            </div>
            <div class="col col-md-2">
                <button class="btn btn-default btn-info" @click="printInvoice"> <i class="fa fa-download"></i> <span>Download</span></button>
            </div>

            <div class="col col-md-2">

                <button v-if="invoice.status==true" class="btn btn-danger" @click="changePaidStatus" > <i class="fa fa-credit-card"></i> <span>Mark As UnPaid</span></button>
                <button v-else class="btn btn-success " @click="changePaidStatus" >  <i class="fa fa-credit-card"></i> <span>Mark As Paid</span></button>
            </div>

            <div class="col col-md-6">
            </div>

        </div>
    </div>

</appLayout>
</template>

<style scoped>
.tab-link {
    color: red;
    padding-left: 30%;
}

hr {
    height: 1px;
    color: #123455;
    background-color: #123455;
    border: none;
}

a {
    text-decoration: none;
}
</style>

<script>
import appLayout from "../../layout/appLayout.vue";
import Vue from 'vue'
import {
    HTTP
} from '../../../common/http-common'
export default {
    components: {
        appLayout,

    },
    methods: {
        editInvoice(data) {

            alert(data.id)

        },
        printInvoice() {
            this.$htmlToPaper('invoicediv');
        },

        customButtonClicked: function (data) {
            console.log(data);

            this.$router.push({
                name: 'ShowParcel',
                params: {
                    id: data.id
                }
            });

        },
        changePaidStatus: function () {

            let url='/invoice/changePaidStatus/'+this.invoice.id;
            HTTP.get(url).then((resp) => {
                 Vue.$toast.open({
                    message: 'Status has changed',
                    type: 'success',
                    // all of other options may go here
                });

                this.invoice = resp.data;
                

            }).catch((error) => {
                console.log(error)
            })

            // this.$router.push({
            //     name: 'ShowParcel',
            //     params: {
            //         id: this.invoice.id
            //     }
            // });

        }
    },
    created() {

        let url = '/invoice/get/' + this.$route.params.id;
        HTTP.get(url).then((resp) => {

            this.invoice = resp.data;

        }).catch((error) => {
            console.log(error)
        })
    },

    data() {
        return {
            invoice: {}

        };
    },
};
</script>
