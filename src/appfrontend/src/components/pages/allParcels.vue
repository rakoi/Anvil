<template>
  <appLayout>
    <div id="allparcels">
      <ul class="nav nav-tabs">
        <li>
          <a data-toggle="tab" href="#home">Incoming Parcels</a>
        </li>
        <hr /> <li>
          <a data-toggle="tab" href="#sent">Sent Parcels</a>
        </li>
        <hr>
        <li>
          <a data-toggle="tab" href="#undelivered">UnCollected Parcels</a>
        </li>
      </ul>

      <div class="tab-content">
        <div id="home" class="tab-pane fade active">
            
          <ParcelDataTable v-bind:url="incomingUrl" />
        </div>

          <div id="sent" class="tab-pane fade active">
            
          <ParcelDataTable v-bind:url="findByOriginUrl" />
        </div>
      
        <div id="undelivered" class="tab-pane fade">
        
          <ParcelDataTable v-bind:url="findUncollectedUrl"  />
        </div>
      </div>
    </div>
  </appLayout>
</template>

<style scoped>
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