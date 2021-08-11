<template>
  <div class="ui container">
    <vuetable
      :fields="this.fields"
      :api-mode="true"
      :api-url="apiUrl"
      :http-options="this.params"
   
      :multi-sort="true"
      data-path="mydata"
      :per-page=10
      :transform="transformData"
       @vuetable:pagination-data="onPaginationData"  
      pagination-path="pagination"
      
    ></vuetable>
   
   <vuetable-pagination ref="pagination"
     @vuetable-pagination:change-page="onChangePage"
 
   ></vuetable-pagination>
  
  </div>
</template>

<script>
import Vuetable from 'vuetable-2/src/components/Vuetable'
//  import VuetablePagination from "vuetable-2/src/components/VuetablePagination";
import VuetablePagination from 'vuetable-2/src/components/VuetablePaginationDropdown'


export default {
  components: {
    Vuetable,
    VuetablePagination,
  },

  props: ["url"],
  created() {
    this.apiUrl = "http://localhost:8096/api/parcel/" + this.url;
  },
  methods: {
    onPaginationData (paginationData) {
      console.log(this.$refs)
      this.$refs.pagination.setPaginationData(paginationData)
    },
    onChangePage (page) {
      console.log(this.$refs)
      this.$refs.vuetable.changePage(page)
    },
    transformData(data) {
      let total = data.totalPages;
      let per_page = 10;
      let current_page = data.number;
      let last_page = Math.round(data.totalElements / data.numberOfElements);
      let next_page = current_page + 1;
      let prev_page = current_page - 1;
      let to = last_page;
      let from = 0;
      if (prev_page < 0) {
        prev_page = 0;
      }
      let next_page_url =
        this.apiUrl + `?sort=id%7Casc&page=${next_page}&per_page=10`;
      let prev_page_url =
        this.apiUrl + `?sort=id%7Casc&page=${prev_page}&per_page=10`;
      var transformed = {};

      transformed.pagination = {
        total: total,
        per_page: per_page,
        current_page: current_page,
        last_page: last_page,
        next_page_url: next_page_url,
        prev_page_url: prev_page_url,
        from: from,
        to: to,
      };
      transformed.mydata = [];

      for (var i = 0; i < data.content.length; i++) {
        let rowdata = data.content[i];
        
        transformed.mydata.push({
          id: rowdata.id,
          reciever: rowdata.reciever,
          sender: rowdata.sender,
          phone: rowdata.sender,
          origin: rowdata.sender,
          destination: rowdata.origin,
          price: rowdata.price,
          amount_paid: rowdata.amount_paid,
          timestamp: rowdata.timestamp,
        });

      }
      return transformed;
    },
  },

  data() {
    return {
      token: localStorage.getItem("anvil_token"),
      apiUrl: "",
      params: {
        headers: {
          Authorization: "Bearer " + localStorage.getItem("anvil_token"),
          "content-type": "application/json",
        },
      },

      fields: [
        { title: "Parcel Id", name: "id", sortField: "id" },
        { title: "Sender", name: "sender.first_name" },
        { title: "Receiver", name: "reciever.first_name" },
        { title: "Phone", name: "reciever.first_name" },
        { title: "Origin", name: "origin.name" },
        { title: "Destination", name: "destination.name" },
        { title: "Price", name: "price", sortField: "price" },
        { title: "Amount_paid", name: "amount_paid" },
        { title: "Date", name: "timestamp" },
      ],
    };
  },
};
</script>