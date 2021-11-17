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

                            <button class="btn btn-success btn-block" @click="startNewTrip">Start</button>
                        </div>
                    </div>

                </form>
            </div>
        </div>
    </div>
    <Toast position="top-right" />
</appLayout>
</template>

<script>
import appLayout from "../../layout/appLayout.vue";
import Toast from 'primevue/toast';

import {
    HTTP
} from '../../../common/http-common'
export default {
    components: {
        appLayout,
        Toast
    },
    methods: {
        startNewTrip: function (e) {
            e.preventDefault();
            let trip = {
                Trip: this.trip
            }

            HTTP.post('/trip/add', trip).then((resp) => {
                console.log(resp)
                this.$router.push({ name: 'showTrip',params:{id:resp.data} })
                // this.$toast.add({
                //     severity: 'success',
                //     summary: 'Success Message',
                //     detail: 'Order submitted',
                //     life: 3000
                // });
               
            });
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

        this.trip.depature = this.getNow;

        HTTP.get('stations/all').then((resp) => {
            this.stations = resp.data;
        })

        HTTP.get('vehicle/all').then((resp) => {
            this.vehicles = resp.data.content;

        })

    },
    data() {
        return {
            stations: {},
            vehicles: {},
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
