<template>
<appLayout>
    <div class="alltrips">

        <div class="row">
            <div class="col col-md-1">
            </div>
            <div class="col col-md-3">

            </div>
        </div>
      
        <MyDatatable :columns="alltripsColumns" :values="alltripsColumnNames" :url="tripUrl" :showDelete=true :showEdit=true :showNew=true :newText="`Start New Trip`" :newUrl="`/trip/new`" :deleteUrl="'trip/delete'" :editUrl="'/trip'" @EditButtonClicked="editTrip" />

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
export default {
    components: {
        appLayout,
        MyDatatable
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
        }
    },

    created() {

    },
    data() {
        return {
            alltripsColumns: [
                "id", "destination", "origin", "arrival", "completed"
            ],
            alltripsColumnNames: [
                "id", "destination", "origin", "arrival", "completed"
            ],
            tripUrl: "trip/all"

        };
    },
};
</script>
