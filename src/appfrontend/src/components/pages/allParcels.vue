<template>
  <appLayout>
    <div id="allparcels">
      <ul class="nav nav-tabs">
        <li >
          <a data-toggle="tab" href="#home">Incoming Parcels</a>
        </li>
        <hr >
           <li class="tab-link">
          <a data-toggle="tab" href="#sent">Sent Parcels</a>
        </li>
         <li class="tab-link">
          <a data-toggle="tab" href="#undelivered">UnCollected Parcels</a>
        </li>
      </ul>

      <div class="tab-content">
        <div id="home" class="tab-pane fade show active">
            
          <ParcelDataTable v-bind:data="this.getIncomingParcels()" />
        </div>

          <div id="sent" class="tab-pane fade ">
            
          <ParcelDataTable v-bind:data="this.getSentParcels()" />
        </div>
      
        <div id="undelivered" class="tab-pane fade">
        
          <ParcelDataTable v-bind:data="this.getUndeliveredParcels()"  />
        </div>
      </div>
    </div>
  </appLayout>
</template>

<style scoped>
.tab-link{
  color:red;
  padding-left:30%;
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
import appLayout from "../layout/appLayout.vue";
import ParcelDataTable from "../widgets/ParcelDataTable.vue";
import { mapActions, mapGetters } from "vuex";
export default {
  components: { appLayout, ParcelDataTable },
  methods: {
    ...mapGetters([
      "getIncomingParcels",
      "getUndeliveredParcels",
      "getSentParcels",
    ]),
    ...mapActions([
      "fetchIncomingParcel",
      "fetchUndeliveredParcels",
      "fetchSentParcels",
    ]),
     
  },
  created() {
    this.fetchIncomingParcel();
    this.fetchUndeliveredParcels();
    this.fetchSentParcels();

   this.getIncomingParcels();
  },
  
  data() {
    return {
      incomingUrl:"incoming",
      findByOriginUrl:"findByOrigin",
      findUncollectedUrl:"findUncollected"

    };
  },
};
</script>