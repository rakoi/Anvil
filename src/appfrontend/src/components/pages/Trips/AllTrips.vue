<template>
  <appLayout>
    <div class="alltrips">
<Button/>
   

   Current page report{{CurrentPageReport}}
<DataTable :value="this.mydata.content" :paginator="true" :rows="15"
    paginatorTemplate="CurrentPageReport FirstPageLink PrevPageLink PageLinks NextPageLink LastPageLink RowsPerPageDropdown"
    :rowsPerPageOptions="[10,20,50]"
    class="p-datatable-striped"
    currentPageReportTemplate="Showing {first} to {last} of {totalRecords}">
     <template #header>
        <div class="table-header">
          
            <span class="p-input-icon-left">
                <i class="pi pi-search" />
                <InputText v-model="filters['global']" placeholder="Global Search" />
            </span>
        </div>
    </template>
    <template #empty>
        No customers found.
    </template>
    <template #loading>
        Loading customers data. Please wait.
    </template>
    <Column field="id" header="id"></Column>
    <Column field="destination" header="destination"></Column>
    <Column field="origin" header="origin"></Column>
    <Column field="arrival" header="arrival"></Column>
    <template #paginatorLeft>
        <Button type="button" icon="pi pi-refresh" class="p-button-text" />
    </template>
    <template #paginatorRight>
        <Button type="button" icon="pi pi-cloud" class="p-button-text" />
    </template>
</DataTable>
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
import appLayout from "../../layout/appLayout.vue";
import DataTable from 'primevue/datatable';
import Column from 'primevue/column';
import InputText from 'primevue/inputtext'
import Button from 'primevue/button'
import axios from 'axios'
export default {
    components: { appLayout,Button,Column,DataTable,InputText },

created(){
       
        axios.get("http://localhost:8096/api/trip/all").then((data)=>{
          this.mydata=data.data;
          console.log(this.mydata.data);
        });
},
  data() {
    return {
         filters: {},
          mydata:{}
        
    
    };
  },
};
</script>