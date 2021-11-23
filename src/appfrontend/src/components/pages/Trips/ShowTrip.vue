<template>
<appLayout>
    <div class="container-fluid">
        <div class="row">
            <div class="col-md-10">

                <form id="newparcelform" method="post">
                    <div class="row">
                        <div class="col-md-6 mb-3">
                            <label for="sfirstName">Origin</label>

                            <select class="form-control" required="true" name="origin" v-model="trip.origin">
                                <option value="">Select Origin</option>
                                <option v-for="station in stations" v-bind:value="station.name" :key="station.id">
                                    {{station.name}}
                                </option>
                            </select>
                        </div>
                        <div class="col-md-6 mb-3">
                            <label for="sfirstName">Destination</label>

                            <select class="form-control" required="true" name="destination" v-model="trip.destination">
                                <option value="">Select Destination</option>
                                <option v-for="station in stations" v-bind:value="station.name" :key="station.id">
                                    {{station.name}}
                                </option>
                            </select>
                        </div>
                    </div>
                </form>
            </div>
        </div>
        <div class="row">
            <div class="col-md-10">
                <form id="newparcelform">
                    <div class="row">
                        <div class="col-md-6 mb-3">

                            <label for="sfirstName">Vehicle</label>

                            <select class="form-control" required="true" name="vehicle" v-model="trip.vehicle">
                                <option value="">Select Vehicle</option>
                                <option v-for="vehicle in vehicles" v-bind:value="vehicle" :key="vehicle.id">
                                    {{vehicle.reg_no}}
                                </option>
                            </select>
                        </div>

                        <div class="col-md-6 mb-3">
                            <label for="sfirstName">Depature Time</label> {{this.timestamp}}
                            <input type="text" class="form-control" placeholder="Depature time" v-model="trip.depature" required="true" />
                        </div>

                    </div>

                    <div class="row">
                        <div class="col-md-4 mb-3">
                        </div>
                        <div class="col-md-6 mb-3">

                            <button class="btn btn-success btn-block" @click="updateTrip">Update</button>
                        </div>
                    </div>

                </form>

                <ul class="nav nav-tabs">
                    <li class="nav-item">
                        <a data-toggle="tab" href="#tripexpenses">Expenses</a>
                    </li>
                    <hr>
                    <li class="nav-item">
                        <a data-toggle="tab" href="#triparcels"> Parcels</a>
                    </li>

                </ul>

                <div class="tab-content">
                    <div id="tripexpenses" class="tab-pane fade show active  ">

                        <MyDatatable :key="expenseCounter" :columns="allExpenseColumns" :values="allExpenseColumnNames" :url="expenseUrl" :showDelete=true :showEdit=true :showNew=true :newText="`Add New Expense`" @newButtonClicked="addExpense" @EditButtonClicked="editExpense" :deleteUrl="'expenses/delete'" />
                    </div>
                    <div id="triparcels" class="tab-pane fade  ">

                        <MyDatatable :key="parcelCounter" :columns="tripParcelColumns" :values="tripParcelColumNames" :url="parcelsUrl" :showDelete=true :deleteUrl="'trip/removeParcel'" :showNew=true :newText="`Add Parcels`" @newButtonClicked="addParcel" />
                    </div>

                </div>

                <!--Edit  Modal -->
                <modal name="editModal">
                    <div class="modal-dialog" role="document">
                        <div class="modal-content">

                            <div class="modal-body">
                                <form>
                                    <div class="row">
                                        <div class="col col-md-12">

                                            <input class="form-control" v-model="editExpenseId" type="hidden" readonly>
                                            <label>Description</label>
                                            <input class="form-control" v-model="editExpenseDescription" type="text" readonly>
                                        </div>
                                    </div>

                                    <div class="row">
                                        <div class="col col-md-12">
                                            <label>Cost</label>
                                            <input class="form-control" v-model="editExpenseCost" type="number">
                                        </div>
                                    </div>

                                </form>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" @click="closeEditModal">Close</button>
                                <button type="button" @click="updateExpense" class="btn btn-primary">Save changes</button>
                            </div>
                        </div>

                    </div>
                </modal>
                <!-- Modal END -->

                <!--Edit  Modal -->
                <modal name="newModal" draggable=".window-header" scrollable:true :width="420" :height="420">
                    <div class="modal-dialog modal-lg" style="width:90%" tabindex="-1" role="dialog ">
                        <div class="modal-content modal-lg">
                            <div class="modal-header">
                                <h5 class="modal-title" id="exampleModalLabel">Add Trip Expense

                                </h5>
                                <button type="button" class="close" data-dismiss="modal" @click="closeNewModal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                            <div class="modal-body modal-lg">
                                <form>

                                    <div class="row">
                                        <div class="col col-md-12">

                                            <input class="form-control" type="hidden" v-model="tripId" readonly>
                                            <label>Expense</label>

                                            <select class="form-control" required="true" name="newexpense" v-model="expense">
                                                <option value="">Select Expense</option>
                                                <option class="form-control" v-for="newexpense in expenses" v-bind:value="newexpense" :key="newexpense.id">
                                                    {{newexpense.name}}
                                                </option>

                                            </select>
                                        </div>
                                    </div>

                                    <div class="row">
                                        <div class="col col-md-12">

                                            <label>Description</label>
                                            <input class="form-control" required v-model="expense.description" type="text">
                                        </div>
                                    </div>

                                    <div class="row">
                                        <div class="col col-md-12">
                                            <label>Cost</label>
                                            <input class="form-control" v-model="expense.cost" type="number">
                                        </div>
                                    </div>

                                </form>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" @click="closeNewModal">Close</button>
                                <button type="submit" @click="addNewExpense" class="btn btn-primary">Save changes</button>
                            </div>
                        </div>

                    </div>
                </modal>
                <!-- Modal END -->

                <!--Edit  Modal -->
                <modal name="newParcelModal" 
                :resizable=true
                 :width="900" 
                 :height="700"
                    :pivot-y="0.3"
                    :scrollable=true
                    :adaptive="true"

                    style="height: auto !important;"
                   
                   >
                    <div class="modal-dialog modal-lg" role="document">
                        <div class="modal-content" style="color:red ; overflow-x: hidden; overflow-y: auto;">
                            <div class="modal-body">
                                <div class="row"  >
                                    <div class="col col-md-8">
                                        <input class="form-control" v-model="newparcelId" autofocus placeholder="PARCEL">
                                    </div>
                                        
                                    <MyDatatable :key="parcelCounter" :columns="tripParcelColumns" :values="tripParcelColumNames" :url="parcelsUrl" :showDelete=true :deleteUrl="'trip/removeParcel'" :newText="`Add Parcels`" @newButtonClicked="addParcel" />

                                </div>
                            </div>

                        </div>

                    </div>
                </modal>
                <!-- Modal END -->

            </div>
        </div>
    </div>

</appLayout>
</template>

<style scoped>
.vm--modal {
    color:red;
  height: auto !important;
}
</style>

<script>
import appLayout from "../../layout/appLayout.vue";
import MyDatatable from '../../widgets/MyDatatable.vue'

import {
    HTTP
} from '../../../common/http-common'
export default {
    components: {
        appLayout,
        MyDatatable,

    },
    watch: {
        newparcelId: function (val) {
            let url = '/trip/addParcel/' + this.tripId + '/' + val;
            console.log(url)
            if (val) {
                HTTP.get(url).then((resp) => {

                    console.log(resp)
                    this.$vToastify.success({
                        title: "success",
                        body: "Parcel added Successfully",
                        duration: 500
                    });
                    this.parcelCounter++;
                    this.newparcelId = null;

                }).catch(() => {
                    this.$vToastify.error({
                        title: "Error",
                        body: "Something went wrong !",
                        duration: 500

                    });

                });
            }
        }
    },
    methods: {
        addNewExpense: function () {

            this.expense.trip = this.trip;

            HTTP.post('/expenses/add', this.expense).then((resp) => {
                console.log(resp)
                this.$vToastify.success("Expense added Successfully");
                this.expense = {},
                    this.closeNewModal();
                this.expenseCounter++;
            }).catch((error) => {
                this.$vToastify.error("Error", "Something went wrong !");
                console.log(error)
            });
        },
        updateTrip: function (e) {
            e.preventDefault();
            console.log(this.trip)
            HTTP.post('/trip/update', this.trip).then((resp) => {
                console.log(resp)
                this.$vToastify.success("Trip Updated Successfully");
                this.closeEditModal();
            }).catch((error) => {
                this.$vToastify.error("Error", "Something went wrong !");
                console.log(error)
            });
        },
        addParcel: function () {
            this.$modal.show("newParcelModal");
            console.log('------------------------')
          
            console.log('------------------------')
        },
        addExpense: function () {

            this.$modal.show(
                "newModal",
            );

        },
        updateExpense: function () {

            this.edit.id = this.editExpenseId;
            this.edit.cost = this.editExpenseCost;
            this.edit.description = this.editExpenseDescription;
            this.edit.trip_id = this.tripId;

            HTTP.post('/expenses/update', this.edit).then((resp) => {
                console.log(resp)
                this.$vToastify.success("Expense Updated Successfully");
                this.closeEditModal();
            }).catch((error) => {
                this.$vToastify.error("Error", "Something went wrong !");
                console.log(error)
            });

        },
        editExpense: function (expenses) {

            this.editExpenseCost = expenses.cost;
            this.editExpenseId = expenses.id;
            this.editExpenseDescription = expenses.description;
            this.edit = expenses;

            this.$modal.show("editModal");
        },
        closeNewModal: function () {
            this.$modal.hide("newModal");
        },
        showModal() {

            this.$modal.show("editModal", {

            });

        },
        closeEditModal() {
            this.$modal.hide("editModal");
        }

    },
    computed: {
        getNow: function () {
            const today = new Date();
            const date = today.getFullYear() + '-' + (today.getMonth() + 1) + '-' + today.getDate();
            const time = today.getHours() + ":" + today.getMinutes() + ":" + today.getSeconds();
            const dateTime = date + ' ' + time;
            return dateTime;
        }
    },
    created() {

        this.tripId = this.$route.params.id;

        this.trip.depature = this.getNow;
        let ajaxurl = '/trip/get/' + this.tripId;
        this.parcelsUrl = 'trip/getParcels/' + this.tripId;
        this.expenseUrl = 'expenses/getByTrip/' + this.tripId;
        this.expense.trip_id = this.tripId;

        HTTP.get('/expense/').then((resp) => {
            this.expenses = resp.data;

        })

        HTTP.get(ajaxurl).then((resp) => {

            this.trip = resp.data;
        });

        HTTP.get('stations/all').then((resp) => {
            this.stations = resp.data;
        })

        HTTP.get('vehicle/get').then((resp) => {
            this.vehicles = resp.data;

        })

    },
    data() {
        return {
            stations: {},
            expenseUrl: '',
            parcelsUrl: '',
            tripId: '',
            vehicles: {},
            edit: {},
            newparcelId: null,
            expenseCounter: 0,
            parcelCounter: 0,
            allExpenseColumns: [
                "id", "description", "cost"
            ],
            allExpenseColumnNames: [
                "id", "description", "cost"
            ],

            tripParcelColumns: [
                "id", "receiver", "sender", "origin", "destination", "kilograms"
            ],
            tripParcelColumNames: [
                "id", "reciever.first_name", "sender.first_name", "origin.name", "destination.name", "kilograms"
            ],

            editExpenseCost: '',
            editExpenseId: '',
            editExpenseDescription: '',

            timestamp: '',
            trip: {
                origin: '',
                destination: '',
                vehicle: '',
                depature: ''
            },
            expenses: [],
            expense: {},

        };
    },
};
</script>
