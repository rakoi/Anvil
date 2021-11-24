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
            
          <MyDatatable 
          :columns="parcelColumns"
           :values="parcelColumnsNames"
            :url="'parcel/allincoming'" 
            :showEdit=true  
             :editUrl="'/trip'" 
             @EditButtonClicked="editParcel" />
        </div>

          <div id="sent" class="tab-pane fade ">
             <MyDatatable 
          :columns="parcelColumns"
           :values="parcelColumnsNames"
            :url="'parcel/findAllByOrigin'" 
            :showEdit=true  
             :editUrl="'/trip'" 
             @EditButtonClicked="editParcel" />
       
        </div>
      
        <div id="undelivered" class="tab-pane fade">
        
            <MyDatatable 
          :columns="parcelColumns"
           :values="parcelColumnsNames"
            :url="'parcel/findAllUncollected'" 
            :showEdit=true  
             :editUrl="'/trip'" 
             @EditButtonClicked="editParcel" />
         
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
import MyDatatable from '../widgets/MyDatatable.vue'
export default {
  components: { appLayout ,MyDatatable},
  methods:{
     editParcel(data) {

            
             this.$router.push({
                 name: 'EditParcel',
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
      parcelColumns:[
        "id",
        "receiver",
        "sender",
        "sender phone",
        "destination",
        "price",
        "kilograms",
        "collected"
      ],
      parcelColumnsNames:[
        "id",
        "reciever.first_name",
        "sender.first_name",
        "sender.phone",
        "destination.name",
        "price",
        "kilograms",
        "collected"
      ]

    };
  },
};
</script>