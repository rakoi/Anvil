<template>
<appLayout>
    <div class="alltrips">

        <div class="row">
            <div class="col col-md-1">
            </div>
            <div class="col col-md-3">

            </div>
        </div>
       
        <MyDatatable :key="counter" :columns="alltripsColumns" :values="alltripsColumnNames" :url="tripUrl" :showDelete=true :showEdit=true :showNew=true :showCustom=true :newText="`Start New Trip`" :newUrl="`/trip/new`" :deleteUrl="'trip/delete'" :editUrl="'/trip'" :editText="`Modify`" :customButtonText="`Finish`" @customButtonClicked="customButtonClicked" @EditButtonClicked="editTrip" />

        <!--Finish Trip  Modal -->
        <modal name="finishModal">
            <div class="modal-dialog" role="document">
                <div class="modal-content">

                    <div class="modal-body" v-if="this.FinishTrip.arrival">
                        Trip was already Completed at {{this.FinishTrip.arrival}}
                    </div>

                    <div class="modal-body" v-else>
                        Finish Trip from {{this.FinishTrip.origin}} to {{this.FinishTrip.destination}}
                    </div>

                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" @click="closeFinishModal">Close</button>
                        <button type="button" class="btn btn-primary" @click="finishTrip">Finish</button>
                    </div>
                </div>

            </div>
        </modal>
        <!-- Finish Trip Modal END -->

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
        editTrip(data) {

            console.log(data.id)
            this.$router.push({
                name: 'showTrip',
                params: {
                    id: data.id
                }
            });
        },
        customButtonClicked: function (data) {
            this.$modal.show("finishModal");
            this.FinishTrip = data;
        },
        closeFinishModal: function () {
            this.$modal.hide("finishModal");
        },
        finishTrip() {
            let finishUrl = '/trip/finish/' + this.FinishTrip.id;
            this.closeFinishModal();
            this.$vToastify.loader("Please Wait...")

            HTTP.get(finishUrl).then((resp) => {
                console.log(resp)
                this.$vToastify.stopLoader()
                this.$vToastify.success("Trip Ended Successfully");
                this.counter++;
            }).catch((error) => {
                console.log(error)
                this.$vToastify.stopLoader()
                this.$vToastify.error("Error", "Something went wrong !");
            })

          

        }
    },

    created() {

    },
    data() {
        return {
            counter:0,
            FinishTrip: {},
            alltripsColumns: [
                "id", "destination", "origin", "arrival", "completed"
            ],
            alltripsColumnNames: [
                "id", "destination", "origin", "arrival", "completed"
            ],
            tripUrl: "trip/user"

        };
    },
};
</script>
