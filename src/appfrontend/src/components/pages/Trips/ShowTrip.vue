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

                            <button class="btn btn-success btn-block" @click="updateTrip" >Update</button>
                        </div>
                    </div>

                </form>

                <h3>Expenes</h3>
                <MyDatatable :columns="allExpenseColumns" :values="allExpenseColumnNames" :url="expenseUrl" :showDelete=true :showEdit=true :showNew=true :newText="`Add New Expense`" @newButtonClicked="addExpense" @EditButtonClicked="editExpense" :deleteUrl="'expenses/delete'" />
                <hr>

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
                <modal name="newModal">
                    <div class="modal-dialog" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title" id="exampleModalLabel">New Expense </h5>
                                <button type="button" class="close" data-dismiss="modal" @click="closeNewModal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                            <div class="modal-body">
                                New Modal
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" @click="closeNewModal">Close</button>
                                <button type="button" class="btn btn-primary">Save changes</button>
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
    methods: {
        updateTrip:function(e){
            e.preventDefault();
            console.log(this.trip)
            HTTP.post('/trip/update',this.trip).then((resp)=>{
                console.log(resp)
                this.$vToastify.success("Trip Updated Successfully");
                this.closeEditModal(); 
            }).catch((error)=>{
                this.$vToastify.error("Error","Something went wrong !");
                console.log(error)
            });
        },
        addExpense: function () {

            this.$modal.show("newModal");

        },
        updateExpense: function () {

            console.log(this.edit)

            this.edit.id = this.editExpenseId;
            this.edit.cost = this.editExpenseCost;
            this.edit.description = this.editExpenseDescription;
            this.edit.trip_id=this.tripId;


            HTTP.post('/expenses/update',this.edit).then((resp)=>{
                console.log(resp)
                this.$vToastify.success("Expense Updated Successfully");
                this.closeEditModal(); 
            }).catch((error)=>{
                this.$vToastify.error("Error","Something went wrong !");
                console.log(error)
            });

        },
        editExpense: function (expenses) {

            this.editExpenseCost = expenses.cost;
            this.editExpenseId = expenses.id;
            this.editExpenseDescription = expenses.description;
            this.edit=expenses;

            console.log('--------------------------')
         
            console.log('--------------------------')

            this.$modal.show("editModal");
        },
        closeNewModal: function () {
            this.$modal.hide("newModal");
        },
        showModal() {

            this.$modal.show("editModal");

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
        this.expenseUrl = 'expenses/getByTrip/' + this.tripId;

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
            tripId: '',
            vehicles: {},
            edit: {},
            allExpenseColumns: [
                "id", "description", "cost"
            ],
            allExpenseColumnNames: [
                "id", "description", "cost"
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
            }

        };
    },
};
</script>
